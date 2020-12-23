package com.rubypaper.Chapter06.exception;

public class BoardNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public BoardNotFoundException(String message) {
        super(message);
    }
}
