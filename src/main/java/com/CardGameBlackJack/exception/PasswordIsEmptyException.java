package com.CardGameBlackJack.exception;

public class PasswordIsEmptyException extends RuntimeException{
    public PasswordIsEmptyException() {
        super("Password cannot be empty");
    }
}
