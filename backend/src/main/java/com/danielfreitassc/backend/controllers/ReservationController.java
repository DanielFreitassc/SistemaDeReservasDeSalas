package com.danielfreitassc.backend.controllers;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danielfreitassc.backend.dtos.ReservationRequestDto;
import com.danielfreitassc.backend.dtos.ReservationResponseDto;
import com.danielfreitassc.backend.services.ReservationService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reservation")
public class ReservationController {
    private final ReservationService reservationService;

    @PostMapping
    public ReservationResponseDto create(@RequestBody @Valid ReservationRequestDto reservationRequestDto) {
        return reservationService.create(reservationRequestDto);
    }

    @GetMapping
    public Page<ReservationResponseDto> getAll(Pageable pageable) {
        return  reservationService.getAllReservations(pageable);
    } 

    @GetMapping("/{id}")
    public ReservationResponseDto getById(@PathVariable UUID id) {
        return  reservationService.getByid(id);
    }

    @PutMapping("/{id}")
    public ReservationResponseDto update(@PathVariable UUID id, @RequestBody @Valid ReservationRequestDto reservationRequestDto) {
        return reservationService.update(id, reservationRequestDto);
    }

    @DeleteMapping("/{id}")
    public ReservationResponseDto delete(@PathVariable UUID id) {
        return  reservationService.delete(id);
    }
}
