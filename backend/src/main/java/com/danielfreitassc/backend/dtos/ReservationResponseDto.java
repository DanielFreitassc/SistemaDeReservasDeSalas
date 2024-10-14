package com.danielfreitassc.backend.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import com.danielfreitassc.backend.models.ReservationEnum;
import com.danielfreitassc.backend.models.RoomEntity;
import com.danielfreitassc.backend.models.UserEntity;

public record ReservationResponseDto(
    UUID id,
    RoomEntity room,
    UserEntity user,
    LocalDateTime startTime,
    LocalDateTime endTime,
    ReservationEnum status,
    BigDecimal totalCost 
) {
    
}
