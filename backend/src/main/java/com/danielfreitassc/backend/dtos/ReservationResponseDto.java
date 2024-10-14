package com.danielfreitassc.backend.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;

import com.danielfreitassc.backend.models.ReservationEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

public record ReservationResponseDto(
    UUID id,
    RoomResponseDto room,
    UserResponseDto user,
    
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    LocalDateTime startTime,

    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    LocalDateTime endTime,
    ReservationEnum status,
    BigDecimal totalCost 
) {
    
}
