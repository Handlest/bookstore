package org.example.bookstore.services.impl;

import org.example.bookstore.domain.entities.*;
import org.example.bookstore.domain.requests.create.BookCreateRequest;
import org.example.bookstore.domain.requests.update.BookUpdateRequest;
import org.example.bookstore.exceptions.EntityNotFoundException;
import org.example.bookstore.repositories.BookRepository;
import org.example.bookstore.repositories.UserRepository;
import org.example.bookstore.services.BookService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Contains logic for operations with Task Entity
 */
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public BookEntity createBook(BookCreateRequest bookRequest, UserEntity user) {  // WHAT THE FUCK
        BookEntity bookEntity = BookEntity.builder()
                .title(bookRequest.getTitle())
                .description(bookRequest.getDescription())
                .authors(bookRequest.getAuthors())
                .language(bookRequest.getLanguage())
                .publishedDate(bookRequest.getPublishDate())
                .publisher(bookRequest.getPublisher())
                .genres(bookRequest.getGenres())
                .price(bookRequest.getPrice())
                .isbn(bookRequest.getIsbn())
                .pageAmount(bookRequest.getPageAmount())
                .bookState(bookRequest.getState())
                .tags(bookRequest.getTags())
                .coverPicture(bookRequest.getBookCoverUrl().getBytes())
                .addedByUser(user)
                .build();
        return bookRepository.save(bookEntity);
    }

    @Override
    public BookEntity findBookByGivenParams(Specification<BookEntity> specification) {
        return bookRepository.findOne(specification).orElseThrow();
    }

    public BookEntity updateBook(BookUpdateRequest bookUpdateRequest) {
        BookEntity bookEntity = bookRepository.findById(bookUpdateRequest.getId())
                .orElseThrow(() -> new EntityNotFoundException("Книга с ID " + bookUpdateRequest.getId() + " не найдена"));

        if (bookUpdateRequest.getTitle() != null) {
            bookEntity.setTitle(bookUpdateRequest.getTitle());
        }
        if (bookUpdateRequest.getDescription() != null) {
            bookEntity.setDescription(bookUpdateRequest.getDescription());
        }
        if (bookUpdateRequest.getAuthors() != null) {
            bookEntity.setAuthors(bookUpdateRequest.getAuthors());
        }
        if (bookUpdateRequest.getLanguage() != null) {
            bookEntity.setLanguage(bookUpdateRequest.getLanguage());
        }
        if (bookUpdateRequest.getPublishDate() != null) {
            bookEntity.setPublishedDate(bookUpdateRequest.getPublishDate());
        }
        if (bookUpdateRequest.getPublisher() != null) {
            bookEntity.setPublisher(bookUpdateRequest.getPublisher());
        }
        if (bookUpdateRequest.getGenres() != null) {
            bookEntity.setGenres(bookUpdateRequest.getGenres());
        }
        if (bookUpdateRequest.getPrice() >= 0) {
            bookEntity.setPrice(bookUpdateRequest.getPrice());
        }
        if (bookUpdateRequest.getIsbn() != null) {
            bookEntity.setIsbn(bookUpdateRequest.getIsbn());
        }
        if (bookUpdateRequest.getPageAmount() > 0) {
            bookEntity.setPageAmount(bookUpdateRequest.getPageAmount());
        }
        if (bookUpdateRequest.getState() != null) {
            bookEntity.setBookState(bookUpdateRequest.getState());
        }
        if (bookUpdateRequest.getTags() != null) {
            bookEntity.setTags(bookUpdateRequest.getTags());
        }

        return bookRepository.save(bookEntity);
    }
    @Override
    public void deleteBookById(long id) {
        bookRepository.deleteBookByBookId(id);
    }

    @Override
    public List<BookEntity> getAllBooks(Pageable pageable, Specification<BookEntity> specification) {
        return bookRepository.findAll(specification, pageable).stream().toList();
    }
}
