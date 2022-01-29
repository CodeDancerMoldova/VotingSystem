package com.example.VotingSystem.dtos;


import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CitizenDTO {

    private String firstName;
    private String lastName;
    private String cardNumber;
    private String city;
    private String street;
}
