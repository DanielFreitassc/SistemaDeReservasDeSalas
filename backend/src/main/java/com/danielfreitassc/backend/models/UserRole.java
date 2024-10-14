package com.danielfreitassc.backend.models;

public enum UserRole {
    ADMIN("ADMIN"),
    CUSTOMER("CUSTOMER");
    
    private String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    } 

    public void setRole(String role) {
        this.role = role;
    }
}
