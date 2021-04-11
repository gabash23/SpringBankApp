package com.example.demo.currency;

public class NotInDatabaseException extends Exception {
    public NotInDatabaseException(String message) {
        super(message);
    }
}
