package org.example.bookstore.exceptions;

public class AccessDeniedException extends BookManagementServiceException {

    public AccessDeniedException(String message, String additionalProp) {
        super(message, additionalProp);
    }

    public AccessDeniedException(String message) {
        super(message);
    }
}
