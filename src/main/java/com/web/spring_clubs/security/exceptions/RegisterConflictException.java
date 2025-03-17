package com.web.spring_clubs.security.exceptions;

public class RegisterConflictException extends RuntimeException {
    public RegisterConflictException(String message) {
        super(message);
    }
}
