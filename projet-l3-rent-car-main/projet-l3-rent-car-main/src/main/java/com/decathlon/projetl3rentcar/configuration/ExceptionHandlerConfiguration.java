package com.decathlon.projetl3rentcar.configuration;

import jakarta.validation.ConstraintViolationException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.NOT_ACCEPTABLE;

@Slf4j
@ControllerAdvice
public class ExceptionHandlerConfiguration extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handle(ConstraintViolationException constraintViolationException) {
        String errorMessage = constraintViolationException.getConstraintViolations().stream()
                .map(cv -> cv.getPropertyPath() + " " + cv.getMessage())
                .sorted()
                .collect(Collectors.joining(". ", "ConstraintViolationException occurred. ", "."));
        return new ResponseEntity<>(new ErrorResponse(NOT_ACCEPTABLE.name(), errorMessage), NOT_ACCEPTABLE);
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<Object> handle(ResponseStatusException responseStatusException) {

        return new ResponseEntity<>(new ErrorResponse(responseStatusException.getStatusCode().toString(), responseStatusException.getReason()), responseStatusException.getStatusCode());
    }

    @Getter
    @AllArgsConstructor
    public static class ErrorResponse {
        String error;
        String errorDescription;
    }
}
