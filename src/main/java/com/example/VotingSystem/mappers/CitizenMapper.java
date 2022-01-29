package com.example.VotingSystem.mappers;

import com.example.VotingSystem.dtos.CitizenDTO;
import com.example.VotingSystem.entities.Citizen;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CitizenMapper {
    CitizenDTO citizenToDTO(Citizen citizen);

    Citizen DTOtoCitizen(CitizenDTO citizenDTO);
}
