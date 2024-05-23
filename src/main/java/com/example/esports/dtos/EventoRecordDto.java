package com.example.esports.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EventoRecordDto(@NotBlank String nome, @NotBlank String localizacao, @NotBlank String time,
                              @NotNull double premiacao) {
}
