package com.danielfreitassc.backend.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.danielfreitassc.backend.dtos.ValidationResponseDTO;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ValidationService {
    

    public ResponseEntity<ValidationResponseDTO> validate(HttpServletRequest request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(authentication != null && authentication.isAuthenticated()) {
            if(request.isUserInRole("ADMIN")) {
                return ResponseEntity.status(HttpStatus.OK).body(new ValidationResponseDTO("Autorizado","ADMIN"));
            } else if(request.isUserInRole("CUSTOMER ")) {
                return ResponseEntity.status(HttpStatus.OK).body(new ValidationResponseDTO("Autorizado","CUSTOMER"));
            }
        }
        
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ValidationResponseDTO("Não autorizado","Você não possui um cargo"));
    }   
}
