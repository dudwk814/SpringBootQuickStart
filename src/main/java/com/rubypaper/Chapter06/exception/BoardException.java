package com.rubypaper.Chapter06.exception;

public class BoardException extends RuntimeException {

    private static final long serialVersionUID = 1l;

    public BoardException(String message) {
        super(message);
    }
}
