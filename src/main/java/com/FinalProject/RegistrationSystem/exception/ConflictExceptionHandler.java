package com.FinalProject.RegistrationSystem.exception;

public class ConflictExceptionHandler extends RuntimeException {
    public ConflictExceptionHandler(String message) {
        super(message);
    }
}
