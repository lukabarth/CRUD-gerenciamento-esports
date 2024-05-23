package com.example.esports.dtos;

import jakarta.validation.constraints.NotBlank;

public record JogoRecordDto(@NotBlank String nome, @NotBlank String modalidade) {
}
