package com.danielfreitassc.backend.dtos;

import com.danielfreitassc.backend.configurations.OnCreate;
import com.danielfreitassc.backend.models.UserRole;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record  UserRequestDto(
    @NotBlank(groups=OnCreate.class, message="O campo nome não pode estar em branco") String name,
    @NotBlank(groups=OnCreate.class, message="O campo sobrenome não pode estar em branco") String lastName,
    @NotBlank(groups=OnCreate.class, message = "O campo username não pode estar em branco") String username,
    @NotBlank(groups=OnCreate.class, message = "O campo senha não pode estar em branco") String password,
    @NotNull(groups=OnCreate.class, message = "Regra de usário não pode ser um campo nulo") UserRole role
) {
    
}
