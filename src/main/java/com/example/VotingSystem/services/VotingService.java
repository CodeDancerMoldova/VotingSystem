package com.example.VotingSystem.services;

import com.example.VotingSystem.dtos.CitizenDTO;
import com.example.VotingSystem.entities.Citizen;
import com.example.VotingSystem.exceptions.AlreadyVotedException;
import com.example.VotingSystem.exceptions.NoSuchCitizenException;
import com.example.VotingSystem.repositories.CandidateRepository;
import com.example.VotingSystem.repositories.CitizenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VotingService {

    private final CitizenRepository citizenRepository;

    public void verifyCitizen(CitizenDTO citizenDTO) {
        Optional<Citizen> citizenFound = citizenRepository.findByIDC(citizenDTO.getCardNumber());
        if (citizenFound.isPresent()) {
            Citizen citizen = citizenFound.get();
            if (citizen.getHasVoted()) {
                throw new AlreadyVotedException("This citizen has already voted!");
            }
        } else {
            throw new NoSuchCitizenException("No such citizen in database with this IDC: " + citizenDTO.getCardNumber());
        }
    }
}
