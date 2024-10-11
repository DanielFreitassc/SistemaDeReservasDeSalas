package com.danielfreitassc.backend.models;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name="rooms")
public class RoomEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private UUID id;
    private String name;
    private String roomNumber;
    private String location;
    private int capacity;
    private BigDecimal price;
    
    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createdAt;
}
