package com.ekwateur.test.domains.customer.exception;

public class CustomerActionFailureException extends RuntimeException {

    public CustomerActionFailureException(String message) {
        super(message);
    }

    public CustomerActionFailureException(String message, Throwable cause) {
        super(message, cause);
    }
}
