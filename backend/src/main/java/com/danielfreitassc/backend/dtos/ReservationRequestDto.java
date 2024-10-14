package com.danielfreitassc.backend.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

import com.danielfreitassc.backend.models.ReservationEnum;

import jakarta.validation.constraints.NotNull;


public record ReservationRequestDto(
    @NotNull(message="Id da sala não pode estar nulo")UUID roomId,
    @NotNull(message="Id de usário não pode estar nulo") UUID userId,
    @NotNull(message="Inicio pode estar nulo") LocalDateTime startTime,
    @NotNull(message="Fim pode estar nulo") LocalDateTime endTime,
    @NotNull(message="Status pode estar nulo") ReservationEnum status
) {
    
}
