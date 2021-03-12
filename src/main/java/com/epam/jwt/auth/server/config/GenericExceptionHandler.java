package com.epam.jwt.auth.server.config;

import com.epam.jwt.auth.server.exception.BadCredentialException;
import com.epam.jwt.auth.server.model.ErrorMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * The type Generic exception handler.
 */
@Slf4j
@ControllerAdvice(basePackages = "com.epam.jwt.auth.server.controller")
public class GenericExceptionHandler extends ResponseEntityExceptionHandler {
    /**
     * Guest not found response entity.
     *
     * @param exception the exception
     * @return the response entity
     */
    @ExceptionHandler(BadCredentialException.class)
    public ResponseEntity<ErrorMessage> guestNotFound(final BadCredentialException exception) {
        ErrorMessage errorResponse = ErrorMessage.builder()
                .errorCode(404)
                .errorMessage(exception.getMessage())
                .build();
        log.error("Error Response = {}", errorResponse);
        return ResponseEntity.badRequest().body(errorResponse);
    }
}
