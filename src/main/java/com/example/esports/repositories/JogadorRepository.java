package com.example.esports.repositories;

import com.example.esports.models.JogadorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JogadorRepository extends JpaRepository <JogadorModel, UUID> {
}
