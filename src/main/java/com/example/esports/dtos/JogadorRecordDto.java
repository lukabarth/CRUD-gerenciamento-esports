package com.example.esports.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record JogadorRecordDto(@NotBlank String nomeJogador, @NotNull int quantidadeTitulos,
                               @NotBlank String timeJogador, @NotBlank String posicao) {
}
