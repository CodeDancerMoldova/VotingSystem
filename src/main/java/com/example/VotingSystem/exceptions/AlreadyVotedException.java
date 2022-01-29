package com.example.VotingSystem.exceptions;


public class AlreadyVotedException extends RuntimeException{
    public AlreadyVotedException(String message) {
        super(message);
    }
}
