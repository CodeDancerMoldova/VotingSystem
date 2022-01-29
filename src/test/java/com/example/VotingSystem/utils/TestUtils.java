package com.example.VotingSystem.utils;

import com.example.VotingSystem.dtos.CitizenDTO;
import com.example.VotingSystem.entities.Citizen;
import com.example.VotingSystem.mappers.CitizenMapper;

public class TestUtils {



    public static final CitizenDTO FOUND_SUCH_CITIZEN_DTO = CitizenDTO.builder()
            .city("Chisinau")
            .cardNumber("B13131231")
            .firstName("Alexandru")
            .lastName("Gumaniuc")
            .street("str.Socoleni.21")
            .build();

    public static final Citizen FOUND_SUCH_CITIZEN_VOTED = Citizen.builder()
            .city("Chisinau")
            .cardNumber("B13131231")
            .firstName("Alexandru")
            .lastName("Gumaniuc")
            .street("str.Socoleni.21")
            .hasVoted(true)
            .build();

    public static final Citizen FOUND_SUCH_CITIZEN_NO_VOTED = Citizen.builder()
            .city("Chisinau")
            .cardNumber("B13131231")
            .firstName("Alexandru")
            .lastName("Gumaniuc")
            .street("str.Socoleni.21")
            .hasVoted(false)
            .build();


}
