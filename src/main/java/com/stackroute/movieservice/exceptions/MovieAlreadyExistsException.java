package com.stackroute.movieservice.exceptions;

public class MovieAlreadyExistsException extends Exception {
    public MovieAlreadyExistsException(String message) {
        super(message);
    }
}
