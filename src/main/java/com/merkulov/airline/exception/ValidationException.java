package com.merkulov.airline.exception;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ValidationException extends RuntimeException {
    private Set<ExceptionErrors> errors;
    private String forwardJsp;

    public ValidationException(String forwardJsp, ExceptionErrors... errors) {
        this.errors = new HashSet(Arrays.asList(errors));
        this.forwardJsp = forwardJsp;
    }

    public ValidationException(String message, String forwardJsp, ExceptionErrors... errors) {
        super(message);
        this.forwardJsp = forwardJsp;
        this.errors = new HashSet(Arrays.asList(errors));
    }

    public ValidationException(String message, Throwable cause, String forwardJsp, ExceptionErrors... errors) {
        super(message, cause);
        this.forwardJsp = forwardJsp;
        this.errors = new HashSet(Arrays.asList(errors));
    }

    public ValidationException(Throwable cause, String forwardJsp, ExceptionErrors... errors) {
        super(cause);
        this.forwardJsp = forwardJsp;
        this.errors = new HashSet(Arrays.asList(errors));
    }

    public Set<ExceptionErrors> getErrors() {
        return errors;
    }

    public String getForwardJsp() {
        return forwardJsp;
    }
}
