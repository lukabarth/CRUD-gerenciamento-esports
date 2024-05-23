package com.example.esports.repositories;

import com.example.esports.models.EquipeModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EquipeRepository extends JpaRepository <EquipeModel, UUID> {
}
