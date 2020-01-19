package com.marvel.demo.exceptions;

public class MissingException extends Exception {
    public MissingException(String msg) {
        super(msg);
    }
    public MissingException() {
    }
}
