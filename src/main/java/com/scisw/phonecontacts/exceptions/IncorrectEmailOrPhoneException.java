package com.scisw.phonecontacts.exceptions;

public class IncorrectEmailOrPhoneException extends RuntimeException{
    public IncorrectEmailOrPhoneException(String message) {
        super(message);
    }
}
