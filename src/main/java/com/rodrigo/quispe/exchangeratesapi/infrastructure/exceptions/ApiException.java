package com.rodrigo.quispe.exchangeratesapi.infrastructure.exceptions;

import lombok.Getter;

@Getter
public class ApiException extends Exception {

    private String message;

    public ApiException(String message) {
        super(message);
        this.message = message;
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
    }

    public ApiException(Throwable cause) {
        super(cause);
    }
}
