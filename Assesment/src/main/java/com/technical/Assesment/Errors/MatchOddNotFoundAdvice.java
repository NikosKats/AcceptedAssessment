package com.technical.Assesment.Errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class MatchOddNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(MatchOddNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String matchOddNotFoundHandler(MatchOddNotFoundException ex) {
        return ex.getMessage();
    }
}