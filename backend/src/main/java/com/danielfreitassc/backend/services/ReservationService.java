package com.danielfreitassc.backend.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
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
import com.danielfreitassc.backend.models.RoomEntity;
import com.danielfreitassc.backend.repositories.ReservationRepository;
import com.danielfreitassc.backend.repositories.RoomRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final ReservationMapper reservationMapper;
    private final RoomRepository roomRepository;

    public ReservationResponseDto create(ReservationRequestDto reservationRequestDto) {
        Optional<RoomEntity> room = roomRepository.findById(reservationRequestDto.roomId());
        if(room.isEmpty()) throw  new ResponseStatusException(HttpStatus.NOT_FOUND,"Quarto não encontrado");
        if (reservationRequestDto.endTime().isBefore(reservationRequestDto.startTime())) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "End time deve ser posterior ao start time");

        long durationInMinutes = Duration.between(reservationRequestDto.startTime(), reservationRequestDto.endTime()).toMinutes();

        if (durationInMinutes <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Duração inválida da reserva");

        BigDecimal durationInHours = BigDecimal.valueOf(durationInMinutes).divide(BigDecimal.valueOf(60), 2, RoundingMode.HALF_UP);
        
        BigDecimal roomPrice = room.get().getPrice();
        if (roomPrice == null || roomPrice.compareTo(BigDecimal.ZERO) == 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Preço do quarto inválido");
        }
        
        BigDecimal totalCost = roomPrice.multiply(durationInHours);

        ReservationEntity reservation = reservationMapper.toEntity(reservationRequestDto);
        reservation.setTotalCost(totalCost);
        reservationRepository.save(reservation);
        return  reservationMapper.toDto(reservation);
    }

    public Page<ReservationResponseDto> getAllReservations(Pageable pageable) {
        Page<ReservationEntity> reservations = reservationRepository.findAllEntitys(pageable);
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
