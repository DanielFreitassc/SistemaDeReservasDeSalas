package com.danielfreitassc.backend.dtos;

import jakarta.validation.constraints.NotBlank;

public record  UserRequestDto(
    @NotBlank(message="O campo nome não pode estar em branco") String name,
    @NotBlank(message="O campo sobrenome não pode estar em branco") String lastName
) {
    
}
