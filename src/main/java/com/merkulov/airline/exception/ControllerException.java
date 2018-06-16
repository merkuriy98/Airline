package com.merkulov.airline.exception;

public class ControllerException extends ValidationException {
    public ControllerException(String forwardJsp, ExceptionErrors... errors) {
        super(forwardJsp, errors);
    }

    public ControllerException(String message, String forwardJsp, ExceptionErrors... errors) {
        super(message, forwardJsp, errors);
    }

    public ControllerException(String message, Throwable cause, String forwardJsp, ExceptionErrors... errors) {
        super(message, cause, forwardJsp, errors);
    }

    public ControllerException(Throwable cause, String forwardJsp, ExceptionErrors... errors) {
        super(cause, forwardJsp, errors);
    }
}
