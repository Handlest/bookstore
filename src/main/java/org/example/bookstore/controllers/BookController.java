package org.example.bookstore.controllers;

import org.example.bookstore.controllers.specifications.BookSpecifications;
import org.example.bookstore.domain.dto.BookDto;
import org.example.bookstore.domain.requests.create.BookCreateRequest;
import org.example.bookstore.domain.requests.update.BookUpdateRequest;
import org.example.bookstore.domain.entities.BookEntity;
import org.example.bookstore.domain.entities.UserEntity;
import org.example.bookstore.mappers.Mapper;
import org.example.bookstore.services.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/books")
@RequiredArgsConstructor
@Validated
@Tag(name = "Работа с книгами")
public class BookController {
    private final BookService bookService;
    private final Mapper<BookEntity, BookDto> bookMapper;

    @Operation(summary = "Добавить новую книгу")
    @SecurityRequirement(name = "JWT")
    @PostMapping
    public ResponseEntity<BookDto> createBook(@AuthenticationPrincipal UserEntity user, @RequestBody @Validated BookCreateRequest taskRequest){
        BookEntity savedBookEntity = bookService.createBook(taskRequest, user);
        return new ResponseEntity<>(bookMapper.mapToDto(savedBookEntity), HttpStatus.CREATED);
    }

    @Operation(summary = "Получить книгу по заданному параметру: bookId, title или isbn")
    @GetMapping(path = "/book")
    public ResponseEntity<BookDto> getBookByParameter(
            @RequestParam(required = false) String bookId,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String isbn) {

        BookEntity book = null;
        Specification<BookEntity> specification = Specification.where(null);

        if (bookId != null) {
            specification = specification.and(BookSpecifications.hasOtherParam("bookId", bookId));
        }
        if (title != null) {
            specification = specification.and(BookSpecifications.hasOtherParam("title", title));
        }
        if (isbn != null) {
            specification = specification.and(BookSpecifications.hasOtherParam("isbn", isbn));
        }


        book = bookService.findBookByGivenParams(specification);



        if (book == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(bookMapper.mapToDto(book));
    }

    @Operation(summary = "Получить список книг по заданным критериям", description = "Возможные параметры: " +
            "page, size, sort (два параметра, по какому полю сортировить, например 'bookId' и порядок сортировки " +
            "asc/desc), language(RUS/ENG), publishers[], genres[], state(NEW/USED), tags[]")
    @SecurityRequirement(name = "JWT")
    @GetMapping(path = "/list")
    public ResponseEntity<List<BookDto>> getAllBooks(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "50") int size,
            @RequestParam(defaultValue = "bookId, asc") String[] sort,
            @RequestParam(required = false) String author,
            @RequestParam(required = false) BookEntity.BOOK_LANGUAGE language,
            @RequestParam(required = false) String[] publishers,
            @RequestParam(required = false) String[] genres,
            @RequestParam(required = false) BookEntity.BOOK_STATE state,
            @RequestParam(required = false) String[] tags) {
        String sortBy = sort[0];
        Sort.Direction direction = Sort.Direction.fromString(sort[1]);
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortBy));
        Specification<BookEntity> specification = Specification.where(null);
        if (author != null) {
            specification = specification.and(BookSpecifications.hasAuthor(author));
        }
        if (language != null) {
            specification = specification.and(BookSpecifications.hasLanguage(language));
        }
        if (publishers != null && publishers.length > 0) {
            specification = specification.and(BookSpecifications.hasPublishers(publishers));
        }
        if (genres != null && genres.length > 0) {
            specification = specification.and(BookSpecifications.hasGenres(genres));
        }
        if (state != null) {
            specification = specification.and(BookSpecifications.hasState(state));
        }
        if (tags != null && tags.length > 0) {
            specification = specification.and(BookSpecifications.hasTags(tags));
        }


        List<BookEntity> queryResult = bookService.getAllBooks(pageable, specification);

        return new ResponseEntity<>(queryResult.stream().map(bookMapper::mapToDto).toList(), HttpStatus.OK);
    }

//    @Operation(summary = "Получить список книг по заданным параметрам")
//    @SecurityRequirement(name = "JWT")
//    @GetMapping(path = "/list")
//    public ResponseEntity<List<BookDto>> getBookByGivenParams(@RequestParam Map<String, String> requestParams) {
//        if (!requestParams.keySet().stream().allMatch(elem -> Arrays.stream(BookSearchParam.values()).findFirst().isPresent())){
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//        List<BookEntity> queryResult = bookService.getAllBooksByGivenParams(requestParams);  // TODO add pageable and specification
//        return new ResponseEntity<>(queryResult.stream().map(bookMapper::mapToDto).toList(), HttpStatus.OK);
//    }

    @Operation(summary = "Изменить книгу")
    @SecurityRequirement(name = "JWT")
    @PutMapping
    @PreAuthorize("@AccessService.canChangeBook(principal, #bookUpdateRequest.bookId())")
    public ResponseEntity<BookDto> updateBook(@RequestBody @Validated BookUpdateRequest bookUpdateRequest) {
        BookEntity bookEntity = bookService.updateBook(bookUpdateRequest);
        return new ResponseEntity<>(bookMapper.mapToDto(bookEntity), HttpStatus.OK);
    }

//    @Operation(summary = "Изменить статус задачи")
//    @SecurityRequirement(name = "JWT")
//    @PatchMapping("/status")
//    @PreAuthorize("@AccessService.canChangeStatus(principal, #request.bookId())")
//    public ResponseEntity<BookDto> patchBookStatus(@RequestBody @Validated BookStatusUpdateRequest request) {
//        BookEntity bookEntity = bookService.updateBookStatus(request.getBookId(), request.getStatus());
//        return new ResponseEntity<>(bookMapper.mapToDto(bookEntity), HttpStatus.OK);
//    }

    @Operation(summary = "Удалить книгу")
    @SecurityRequirement(name = "JWT")
    @DeleteMapping(path = "/{id}")
    @PreAuthorize("@AccessService.canChangeBook(principal, #id)")
    public ResponseEntity<HttpStatus> deleteBook(@PathVariable long id) {
        bookService.deleteBookById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

