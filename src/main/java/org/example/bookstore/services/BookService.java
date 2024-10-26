package org.example.bookstore.services;

import org.example.bookstore.domain.entities.UserEntity;
import org.example.bookstore.domain.requests.create.BookCreateRequest;
import org.example.bookstore.domain.requests.update.BookUpdateRequest;
import org.example.bookstore.domain.entities.BookEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public interface BookService {
    BookEntity createBook(BookCreateRequest request, UserEntity user);
    BookEntity findBookByGivenParams(Specification<BookEntity> specification);
//    List<BookEntity> getAllBooksByGivenParams(Map<String, String> params);
//    BookEntity getBookById(long id);
//    BookEntity getBookByName(String name);
    List<BookEntity> getAllBooks(Pageable pageable, Specification<BookEntity> specification);
    BookEntity updateBook(BookUpdateRequest request);
    void deleteBookById(long id);
}
