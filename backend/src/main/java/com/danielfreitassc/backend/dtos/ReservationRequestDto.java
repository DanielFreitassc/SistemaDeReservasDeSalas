package com.danielfreitassc.backend.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotNull;


public record ReservationRequestDto(
    @NotNull(message="Id da sala não pode estar nulo")UUID roomId,
    @NotNull(message="Id de usário não pode estar nulo") UUID userId,
    
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @NotNull(message="Inicio pode estar nulo") LocalDateTime startTime,
    
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @NotNull(message="Fim pode estar nulo") LocalDateTime endTime
) {
    
}
