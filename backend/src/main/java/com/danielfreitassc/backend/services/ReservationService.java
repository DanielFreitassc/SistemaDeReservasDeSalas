package com.danielfreitassc.backend.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.danielfreitassc.backend.dtos.ReservationRequestDto;
import com.danielfreitassc.backend.dtos.ReservationResponseDto;
import com.danielfreitassc.backend.mappers.ReservationMapper;
import com.danielfreitassc.backend.models.ReservationEntity;
import com.danielfreitassc.backend.repositories.ReservationRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final ReservationMapper reservationMapper;

    public ReservationResponseDto create(ReservationRequestDto reservationRequestDto) {
        return  reservationMapper.toDto(reservationRepository.save(reservationMapper.toEntity(reservationRequestDto)));
    }

    public Page<ReservationResponseDto> getAllReservations(Pageable pageable) {
        Page<ReservationEntity> reservations = reservationRepository.findAll(pageable);
        return reservations.map(reservationMapper::toDto);
    }

    public ReservationResponseDto getByid(UUID id) {
        Optional<ReservationEntity> reservation = reservationRepository.findById(id);
        if(reservation.isEmpty()) throw  new ResponseStatusException(HttpStatus.NOT_FOUND,"Nenhuma reserva encontrada");
        return  reservationMapper.toDto(reservation.get());
    }

    public ReservationResponseDto update(UUID id,ReservationRequestDto reservationRequestDto) {
        Optional<ReservationEntity> reservation = reservationRepository.findById(id);
        if(reservation.isEmpty()) throw  new ResponseStatusException(HttpStatus.NOT_FOUND,"Nenhuma reserva encontrada");
        ReservationEntity reservationEntity = reservationMapper.toEntity(reservationRequestDto);
        reservationEntity.setId(id);
        return  reservationMapper.toDto(reservationRepository.save(reservationEntity));
    }

    public ReservationResponseDto delete(UUID id) {
        Optional<ReservationEntity> reservation = reservationRepository.findById(id);
        if(reservation.isEmpty()) throw  new ResponseStatusException(HttpStatus.NOT_FOUND,"Nenhuma reserva encontrada");
        reservationRepository.delete(reservation.get());
        return  reservationMapper.toDto(reservation.get());
    }
}
