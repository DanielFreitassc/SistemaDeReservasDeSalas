package com.danielfreitassc.backend.dtos;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record  RoomRequestDto(
    @NotBlank(message="Nome da sala não pode estar em branco!") String name,
    @NotBlank(message="Número da sala não pode estar em branco!") String roomNumber,
    @NotBlank(message="local da sala não pode estar em branco!") String location,
    @NotNull int capacity,
    @NotNull BigDecimal price
) {
    
}
