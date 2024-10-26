package org.example.bookstore.exceptions;

public class EntityNotFoundException extends BookManagementServiceException {

    public EntityNotFoundException(String message, String additionalProp) {
        super(message, additionalProp);
    }

    public EntityNotFoundException(String message) {
        super(message);
    }
}
