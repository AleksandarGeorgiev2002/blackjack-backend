package com.CardGameBlackJack.exception;

public class EmailNotValidException extends RuntimeException{
    public EmailNotValidException(String email) {
        super("Email " + email + " is not valid!");
    }
}
