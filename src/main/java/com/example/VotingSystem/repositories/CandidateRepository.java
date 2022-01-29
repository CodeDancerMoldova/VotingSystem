package com.example.VotingSystem.repositories;

import com.example.VotingSystem.entities.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Integer> {

    @Override
    Optional<Candidate> findById(Integer integer);
}
