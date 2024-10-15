package com.danielfreitassc.backend.dtos;

import java.math.BigDecimal;
import java.util.UUID;

import com.danielfreitassc.backend.models.RoomStatus;

public record RoomResponseDto(
    UUID id,
    String name,
    String roomNumber,
    String location,
    int capacity,
    BigDecimal price,
    RoomStatus status
) {
    
}
