package com.danielfreitassc.backend.models;

public enum ReservationEnum {
    DISPONIVEL("Disponível"),
    RESERVADO("Reservado"),
    CANCELADO("Cancelado");

    private final String status;

    ReservationEnum(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
