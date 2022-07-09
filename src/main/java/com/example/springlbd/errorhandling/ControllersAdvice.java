package com.example.springlbd.errorhandling;


import org.springframework.dao.EmptyResultDataAccessException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.io.IOException;

@ControllerAdvice
public class ControllersAdvice {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Error> handleIllegalArgumentException(
            IllegalArgumentException ex){
        return new ResponseEntity<>(
                new Error(ex.getMessage()),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<Error> handleEmptyResultDataAccess(
            EmptyResultDataAccessException ex){
        return new ResponseEntity<>(
                new Error(ex.getCause().getMessage()),
                HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(MethodArgumentTypeMismatchException.class )
    public ResponseEntity<Error> handleMethodArgumentTypeMismatch(
            MethodArgumentTypeMismatchException ex) {
        return new ResponseEntity<>(
                new Error(
                    ex.getMessage(),
                    ex.getName() + " should be of type " + ex.getRequiredType().getName()
                ),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    protected ResponseEntity<Error> handleMissingServletRequestParameter(
            MissingServletRequestParameterException ex) {
        return new ResponseEntity<>(
                new Error(
                        ex.getParameterName() + " parameter is missing",
                        ex.getMessage()
                ),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IOException.class)
    protected ResponseEntity<Error> handleMissingServletRequestParameter(
            IOException ex) {
        return new ResponseEntity<>(
                new Error(
                        "File error",
                        ex.getMessage()
                ),
                HttpStatus.BAD_REQUEST);
    }

}
