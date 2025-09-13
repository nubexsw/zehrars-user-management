package com.zehra.realstate.usermanagement.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;

@ControllerAdvice
public class ServiceExceptionHandler extends ResponseEntityExceptionHandler {

    // This class can be used to handle exceptions globally for the application.
    // You can override methods from ResponseEntityExceptionHandler to customize
    // the response for specific exceptions.

    // For example, you can handle DataNotFoundException here and return a custom response.

    // @ExceptionHandler(DataNotFoundException.class)
    // public ResponseEntity<Object> handleDataNotFoundException(DataNotFoundException ex) {
    //     return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    // }
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        // This method can be overridden to handle generic exceptions
        ErrorDetails error = new ErrorDetails(
                LocalDate.now(),
                ex.getMessage(),
                request.getDescription(false)
        );
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DataNotFoundException.class)
    public final ResponseEntity<Object> handleDataNotFoundException(DataNotFoundException ex, WebRequest request) {
        // This method can be overridden to handle generic exceptions
        ErrorDetails error = new ErrorDetails(
                LocalDate.now(),
                ex.getMessage(),
                request.getDescription(false)
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        String detail = ex.getFieldErrors().stream()
                .map(FieldError::getDefaultMessage)
                .reduce((s1, s2) -> s1 + ", " + s2)
                .orElse("Validation error");
        String message = String.format("Total Errors: %d, Detail: %s",
                ex.getFieldErrorCount(),
                detail
        );

        ErrorDetails error = new ErrorDetails(
                LocalDate.now(),
                message,
                request.getDescription(false)
        );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
