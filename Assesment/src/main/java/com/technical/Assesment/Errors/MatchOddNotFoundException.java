package com.technical.Assesment.Errors;

public class MatchOddNotFoundException extends RuntimeException {

    public MatchOddNotFoundException(Long id) {
        super("Could not find match odd" + id);
    }
}