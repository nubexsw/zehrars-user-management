package com.zehra.realstate.usermanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

// The exception is annotated with @ResponseStatus to return a 404 Not Found status when thrown
// but it is recommended to use a @ControllerAdvice class to handle exceptions globally
// Using @ControllerAdvice provides more flexibility and separation of concerns and it replaces the need for @ResponseStatus on each exception class
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class DataNotFoundException extends RuntimeException {
    
    @Serial
    private static final long serialVersionUID = 1L;

    public DataNotFoundException(String message) {
        super(message);
    }

    public DataNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
