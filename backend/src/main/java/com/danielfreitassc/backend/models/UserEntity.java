package com.danielfreitassc.backend.models;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserEntity implements UserDetails{
    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private UUID id;
    private String name;
    private String username;
    private String lastName;

    @CreationTimestamp
    private Timestamp createdAt;


    @Length(min = 10, max = 100, message = "A senha deve conter entre (10) e (100) caracteres")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z]).*$", message = "A senha precisa ter pelo menos um caractere maiúsculo e um caractere minúsculo")
    private String password;

    @Enumerated(EnumType.ORDINAL)
    private UserRole role;

    @Column(name = "login_attempts")
    private int loginAttempts = 0;

    @Column(name = "lockout_expiration")
    private LocalDateTime lockoutExpiration;

    public void lockAccount() {
        this.lockoutExpiration = LocalDateTime.now().plusMinutes(10);
    }

    public boolean isAccountLocked() {
        return lockoutExpiration != null && LocalDateTime.now().isBefore(lockoutExpiration);
    }

    public UserEntity(String name, String username, String password, UserRole role) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.role = (role != null) ? role : UserRole.CUSTOMER;
    }

    public void incrementLoginAttempts() {
        this.loginAttempts++;
    }

    public void resetLoginAttempts() {
        this.loginAttempts = 0;
    }

   @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        if (this.role != null) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + this.role.getRole().toUpperCase()));
        }
        return authorities;
    }
    @Override
    public String getUsername() {
        return username;
    }
    @Override
    public boolean isAccountNonExpired() {
        return !isAccountLocked();
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }
}