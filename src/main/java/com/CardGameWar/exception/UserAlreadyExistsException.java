package com.CardGameWar.exception;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(String username) {
        super(String.format("User with id '%s' already exists!", username));
    }
}
