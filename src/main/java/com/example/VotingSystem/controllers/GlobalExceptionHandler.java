package com.example.VotingSystem.controllers;

import com.example.VotingSystem.entities.HttpResponse;
import com.example.VotingSystem.exceptions.NoSuchCitizenException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoSuchCitizenException.class)
    public ResponseEntity<?> handleNoSuchCitizenException(NoSuchCitizenException noSuchCitizenException
            , WebRequest webRequest){
        HttpResponse httpResponse = new HttpResponse(noSuchCitizenException.getMessage());
        return new ResponseEntity(httpResponse,HttpStatus.BAD_REQUEST);
    }


}
