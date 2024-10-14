package com.danielfreitassc.backend.dtos;

import java.util.UUID;

public record UserResponseDto(
    UUID id,
    String name,
    String lastName,
    String username
) {
    
}
