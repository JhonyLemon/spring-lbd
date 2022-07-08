package com.example.springlbd.errorhandling;

public class ErrorMessage {

    private String ErrorMessage;

    public ErrorMessage(String errorMessage) {
        ErrorMessage = errorMessage;
    }

    public ErrorMessage() {
    }

    public String getErrorMessage() {
        return ErrorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        ErrorMessage = errorMessage;
    }
}
