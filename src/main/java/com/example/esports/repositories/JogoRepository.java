package com.example.esports.repositories;

import com.example.esports.models.JogoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JogoRepository extends JpaRepository <JogoModel, UUID> {
}
