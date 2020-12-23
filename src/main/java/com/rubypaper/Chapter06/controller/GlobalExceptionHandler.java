package com.rubypaper.Chapter06.controller;

import com.rubypaper.Chapter06.exception.BoardException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BoardException.class)
    public String handleCustomException(BoardException exception, Model model) {
        model.addAttribute("exception", exception);
        return "/errors/boardError";
    }

    @ExceptionHandler(Exception.class)
    public String handlerException(Exception exception, Model model) {
        model.addAttribute("exception", exception);
        return "/errors/globalError";
    }
}
