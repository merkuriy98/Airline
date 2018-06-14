package com.merkulov.airline.exception;

public class RepositoryException extends Exception {
    private static final long serialVersionUID = 3038970175081657383L;

    public RepositoryException(String message, Throwable cause) {
        super(message, cause);
    }
}
