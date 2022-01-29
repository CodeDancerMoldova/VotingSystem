package com.example.VotingSystem.repositories;

import com.example.VotingSystem.entities.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;


@Repository
public interface CitizenRepository extends JpaRepository<Citizen, UUID> {

    Optional<Citizen> findByIDC(String idc);

}
