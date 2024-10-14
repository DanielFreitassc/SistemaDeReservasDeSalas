package com.danielfreitassc.backend.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

import com.danielfreitassc.backend.models.ReservationEnum;


public record ReservationRequestDto(
    UUID roomId,
    UUID userId,
    LocalDateTime startTime,
    LocalDateTime endTime,
    ReservationEnum status
) {
    
}
