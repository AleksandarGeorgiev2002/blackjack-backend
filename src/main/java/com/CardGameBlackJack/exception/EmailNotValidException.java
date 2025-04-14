package com.CardGameBlackJack.exception;

public class EmailNotValidException extends RuntimeException{
    public EmailNotValidException() {
        super("Email is not valid!");
    }
}
