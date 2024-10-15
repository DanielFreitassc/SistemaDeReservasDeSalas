package com.danielfreitassc.backend.models;

public enum RoomStatus {
    DISPONIVEL("Disponível"),
    RESERVADO("Reservado"),
    CANCELADO("Cancelado");

    private final String status;

    RoomStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
