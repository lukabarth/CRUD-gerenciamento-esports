package com.example.esports.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EquipeRecordDto(@NotBlank String nome, @NotNull int numeroTitulos,
                              @NotBlank String categoria, @NotBlank String jogos,
                              @NotNull Boolean inscrito) {
}
