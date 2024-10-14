package com.danielfreitassc.backend.infra.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfigurations {
    private final SecurityFilter securityFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize

                .requestMatchers(HttpMethod.POST,"/user").permitAll()
                .requestMatchers(HttpMethod.GET,"/user").permitAll()
                .requestMatchers(HttpMethod.GET,"/user/{id}").permitAll()
                .requestMatchers(HttpMethod.PATCH,"/user/{id}").permitAll()
                .requestMatchers(HttpMethod.DELETE,"/user/{id}").permitAll()
                
                
                .requestMatchers(HttpMethod.POST,"/room").hasRole("ADMIN")
                .requestMatchers(HttpMethod.GET,"/room").hasRole("ADMIN")
                .requestMatchers(HttpMethod.GET,"/room/{id}").hasRole("ADMIN")
                .requestMatchers(HttpMethod.PUT,"/room/{id}").hasRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE,"/room/{id}").hasRole("ADMIN")
                
                .requestMatchers(HttpMethod.POST,"/reservation").hasAnyRole("ADMIN","CUSTOMER")
                .requestMatchers(HttpMethod.GET,"/reservation").hasAnyRole("ADMIN","CUSTOMER")
                .requestMatchers(HttpMethod.GET,"/reservation/{id}").hasAnyRole("ADMIN","CUSTOMER")
                .requestMatchers(HttpMethod.PUT,"/reservation/{id}").hasAnyRole("ADMIN","CUSTOMER")
                .requestMatchers(HttpMethod.DELETE,"/reservation/{id}").hasAnyRole("ADMIN","CUSTOMER")
                
                .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                .requestMatchers(HttpMethod.GET,"/validation").hasAnyRole("ADMIN","CUSTOMER")

                //Permite o swagger
                .requestMatchers(HttpMethod.GET,"/v3/api-docs/swagger-config").permitAll()
                .requestMatchers(HttpMethod.GET,"/v3/api-docs").permitAll()
                .requestMatchers(HttpMethod.GET,"/swagger-ui/**").permitAll()


                // Configuração para endpoint de erro
                .requestMatchers("/error").anonymous()
                .anyRequest().authenticated()

                ).addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class).build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
