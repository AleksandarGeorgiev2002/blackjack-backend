package com.CardGameBlackJack.exception;

public class PasswordNotValidException extends RuntimeException{
    public PasswordNotValidException(String password) {
        super("Password '" + password + "' is not valid!");
    }
}
