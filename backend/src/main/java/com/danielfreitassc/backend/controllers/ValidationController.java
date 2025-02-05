package com.danielfreitassc.backend.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danielfreitassc.backend.dtos.ValidationResponseDTO;
import com.danielfreitassc.backend.services.ValidationService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/validation")
public class ValidationController {
    private final ValidationService validationService;

    @GetMapping
    public ValidationResponseDTO validate(HttpServletRequest request) {
        return validationService.validate(request);
    }
}
