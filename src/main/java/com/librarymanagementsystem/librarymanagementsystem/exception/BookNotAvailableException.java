package com.librarymanagementsystem.librarymanagementsystem.exception;

public class BookNotAvailableException extends RuntimeException{
    public BookNotAvailableException(String message) {
        super(message);
    }
}
