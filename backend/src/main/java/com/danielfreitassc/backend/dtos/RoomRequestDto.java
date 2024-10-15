package com.danielfreitassc.backend.dtos;

import java.math.BigDecimal;

import com.danielfreitassc.backend.models.RoomStatus;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record  RoomRequestDto(
    @NotBlank(message="Nome da sala não pode estar em branco!") String name,
    @NotBlank(message="Número da sala não pode estar em branco!") String roomNumber,
    @NotBlank(message="local da sala não pode estar em branco!") String location,
    @NotNull @Min(value=0,message="Capacidade não pode ser negativa") int capacity,
    @NotNull @Min(value=0,message="Preço não pode ser negativo") BigDecimal price,
    @NotNull(message="Status do quarto não pode ser nulo") RoomStatus status
) {
    
}
