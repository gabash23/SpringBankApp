package com.example.demo.currency;

public class NotEnoughMoneyException extends Exception {
    public NotEnoughMoneyException(String message) {
        super(message);
    }
}
