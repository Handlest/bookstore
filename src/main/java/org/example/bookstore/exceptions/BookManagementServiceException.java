package org.example.bookstore.exceptions;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class BookManagementServiceException extends RuntimeException {
    private final Map<String, Object> params = new HashMap<>();

    public BookManagementServiceException(String message, String additionalProp) {
        super(message);
        this.params.put("Additional properties", additionalProp);
    }

    public BookManagementServiceException(String message) {
        super(message);
    }
}
