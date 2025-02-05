package com.danielfreitassc.backend.services;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.danielfreitassc.backend.dtos.ValidationResponseDTO;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ValidationService {
    
    public ValidationResponseDTO validate(HttpServletRequest request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(authentication != null && authentication.isAuthenticated()) {
            if(request.isUserInRole("ADMIN")) {
                return new ValidationResponseDTO("Autorizado","ADMIN");
            } else if(request.isUserInRole("CUSTOMER ")) {
                return new ValidationResponseDTO("Autorizado","CUSTOMER");
            }
        }
        
        throw new ResponseStatusException(HttpStatus.FORBIDDEN,"Não autorizado");
    }   
}
