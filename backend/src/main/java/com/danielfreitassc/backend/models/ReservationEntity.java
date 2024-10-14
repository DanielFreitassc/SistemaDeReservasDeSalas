package com.danielfreitassc.backend.models;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="reservation")
public class ReservationEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private UUID id;   

    @ManyToOne
    @JoinColumn(name="roomId")
    private RoomEntity roomEntity;

    @ManyToOne
    @JoinColumn(name="userId")
    private UserEntity userEntity;

    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime startTime;

    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime endTime;
    private ReservationEnum status;
    private BigDecimal totalCost;
    @CreationTimestamp
    private Timestamp createdAt;
}
