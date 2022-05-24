package com.project.custom_exception_handler;

public class NoSuchClientException extends RuntimeException {

    public NoSuchClientException(String message) {
        super(message);
    }
}
