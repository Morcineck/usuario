package com.morcineck.usuario.infrastructure.exceptions;

public class IllegalArgumentBusinessException extends RuntimeException {
    public IllegalArgumentBusinessException(String message) {
        super(message);
    }

    public IllegalArgumentBusinessException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
