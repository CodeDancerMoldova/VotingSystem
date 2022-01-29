package com.example.VotingSystem.controllers;

import com.example.VotingSystem.dtos.CitizenDTO;
import com.example.VotingSystem.services.VotingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/voting")
@RequiredArgsConstructor
public class VotingController{

    private final VotingService votingService;

    @PostMapping
    public ResponseEntity<Void> loginCredentials(@RequestBody CitizenDTO citizenDTO){
            votingService.verifyCitizen(citizenDTO);
            return ResponseEntity.noContent().build();
    }
}
