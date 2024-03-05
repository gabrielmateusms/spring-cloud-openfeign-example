package com.github.gabrielmateusms.openfeignexample.exception;

public class RequestException extends RuntimeException {
    public RequestException(String message) {
        super(message);
    }
}
