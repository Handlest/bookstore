package org.example.bookstore.exceptions;

import org.example.bookstore.domain.responses.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.UUID;

@Slf4j
@RestControllerAdvice
public class ExceptionResponseHandler {

    @ExceptionHandler({AccessDeniedException.class, EntityNotFoundException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleAccessDeniedException(BookManagementServiceException exception) {
        return ErrorResponse.builder()
                .id(UUID.randomUUID())
                .message(exception.getMessage())
                .params(exception.getParams())
                .build();
    }
}
