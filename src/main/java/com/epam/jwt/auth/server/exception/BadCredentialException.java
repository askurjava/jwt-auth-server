package com.epam.jwt.auth.server.exception;


/**
 * The type Bad credential exception.
 */
public class BadCredentialException extends RuntimeException {

    /**
     * Instantiates a new Bad credential exception.
     *
     * @param message the message
     */
    public BadCredentialException(String message) {
        super(message);
    }
}
