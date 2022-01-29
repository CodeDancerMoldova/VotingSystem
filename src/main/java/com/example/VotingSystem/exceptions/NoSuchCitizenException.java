package com.example.VotingSystem.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class NoSuchCitizenException extends RuntimeException {
    public NoSuchCitizenException(String message) {
        super(message);
    }
}
