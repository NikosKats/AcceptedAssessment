package com.technical.Assesment.Errors;

public class MatchNotFoundException extends RuntimeException {

    public MatchNotFoundException(Long id) {
        super("Could not find match " + id);
    }
}