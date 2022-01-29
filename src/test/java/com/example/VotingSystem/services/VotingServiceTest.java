package com.example.VotingSystem.services;

import com.example.VotingSystem.dtos.CitizenDTO;
import com.example.VotingSystem.entities.Citizen;
import com.example.VotingSystem.exceptions.AlreadyVotedException;
import com.example.VotingSystem.exceptions.NoSuchCitizenException;
import com.example.VotingSystem.mappers.CitizenMapper;
import com.example.VotingSystem.repositories.CitizenRepository;
import com.example.VotingSystem.utils.TestUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.Mapper;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static com.example.VotingSystem.utils.TestUtils.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class VotingServiceTest {


    @Mock
    private CitizenRepository citizenRepository;

    @InjectMocks
    private VotingService votingService;


    @Test
    void verifyCitizen_isOk_and_Returns_Nothing() {

        Optional<Citizen> citizen = Optional.of(FOUND_SUCH_CITIZEN_NO_VOTED);
        when(citizenRepository.findByIDC(FOUND_SUCH_CITIZEN_DTO.getCardNumber()))
                .thenReturn(citizen);

         assertDoesNotThrow(()->votingService.verifyCitizen(FOUND_SUCH_CITIZEN_DTO));
    }

    @Test
    void verifyCitizen_and_Returns_Already_Voted(){

        Optional<Citizen> citizen = Optional.of(FOUND_SUCH_CITIZEN_VOTED);
        when(citizenRepository.findByIDC(FOUND_SUCH_CITIZEN_DTO.getCardNumber()))
                .thenReturn(citizen);

        assertThatThrownBy(()->votingService.verifyCitizen(FOUND_SUCH_CITIZEN_DTO))
                .isInstanceOf(AlreadyVotedException.class).hasMessage("This citizen has already voted!");

    }

    @Test
    void verifyCitizen_and_Returns_NoSuch_Citizen_Exception(){
        Optional<Citizen> citizen = Optional.empty();
        when(citizenRepository.findByIDC(FOUND_SUCH_CITIZEN_DTO.getCardNumber()))
                .thenReturn(citizen);

        assertThatThrownBy(()->votingService.verifyCitizen(FOUND_SUCH_CITIZEN_DTO))
                .isInstanceOf(NoSuchCitizenException.class).hasMessageContaining("No such citizen in database with this IDC: ");
    }
}