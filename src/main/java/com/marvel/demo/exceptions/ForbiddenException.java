package com.marvel.demo.exceptions;

public class ForbiddenException extends Exception {
    public ForbiddenException(String msg) {
        super(msg);
    }
    public ForbiddenException() {
    }
}
