package com.example.esports.repositories;

import com.example.esports.models.EventoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EventoRepository extends JpaRepository <EventoModel, UUID> {
}
