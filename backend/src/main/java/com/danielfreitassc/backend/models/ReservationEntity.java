package com.danielfreitassc.backend.models;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

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

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private ReservationEnum status;

    @CreationTimestamp
    private Timestamp createdAt;
}
