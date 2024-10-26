package org.example.bookstore.services;

import org.example.bookstore.domain.entities.BookEntity;
import org.example.bookstore.domain.entities.UserEntity;
import org.example.bookstore.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

/**
 * Defines assess rules for users needed to perform actions
 */
@Service("AccessService")
@RequiredArgsConstructor
@Slf4j
public class AccessService {

    private final BookRepository bookRepository;

    /**
     * Проверяет, может ли пользователь выполнять операцию изменения задачи (Например, изменения названия или описания)
     * @param userEntity Пользователь, получаемый из Principal
     * @param taskId id задачи
     * @return True/False
     */
    public boolean canChangeBook(UserEntity userEntity, long taskId) {
        Optional<BookEntity> book = bookRepository.findById(taskId);
        return book.isPresent() && Objects.equals(userEntity.getRole(), UserEntity.Role.ADMIN);
    }

    /**
     * Проверяет, может ли пользователь выполнять операцию изменения статуса задачи TaskEntity. Статус задачи может
     * изменять как владелец задачи, так и человек, которому она была назначена
     * @param userEntity Пользователь, получаемый из Principal
     * @param taskId id задачи
     * @return True/False
     */
//    public boolean canChangeStatus(UserEntity userEntity, long taskId) {
//        Optional<BookEntity> book = bookRepository.findById(taskId);
//        return book.isPresent() && (Objects.equals(userEntity.getUserId(), book.get().getCreatedByUser().getUserId()) ||
//                Objects.equals(userEntity.getUserId(), book.get().getAssignedUser().getUserId()));
//    }

    /**
     * Проверяет, может ли пользователь выполнять операцию изменения статуса комментария CommentEntity
     * @param userEntity Пользователь, получаемый из Principal
     * @param commentId id комментария
     * @return True/False
     */
//    public boolean canChangeComment(UserEntity userEntity, long commentId) {
//        Optional<CommentEntity> comment = commentRepository.findById(commentId);
//        return comment.isPresent() && Objects.equals(comment.get().getAuthor().getUserId(), userEntity.getUserId());
//    }
}
