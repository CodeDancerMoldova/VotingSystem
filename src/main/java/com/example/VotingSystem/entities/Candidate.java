package com.example.VotingSystem.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Candidate {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int numberOfVotes;

}
