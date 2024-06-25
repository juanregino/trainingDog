package com.trainingDog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.trainingDog.infraestructure.helpers.JwtAuthenticationFilter;
import com.trainingDog.utils.enums.Role;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Autowired
  private AuthenticationProvider authenticationProvider;

  @Autowired
  private JwtAuthenticationFilter jwtAuthenticationFilter;

  // Rutas públicas
  private static final String[] PUBLIC_RESOURCES = {
      "/auth/**",
      "/swagger-ui/**",
      "/v3/api-docs/**",
      "/v3/api-docs.yaml",
      "/swagger-ui.html",
      "/educational-resource/get/**",
      
  };

  // Rutas para administradores
  private static final String[] ADMIN_RESOURCES = {
      "/admin/**",
      "/training-program/**",
      "/educational-resource/**",
      "/training/**"
  };

  // Rutas para entrenadores
  private static final String[] TRAINER_RESOURCES = {
      "/training-program/get/**",
      "/dogs/**",
      "/progress/**"
  };

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    return http.csrf(csrf -> csrf
        .disable()) // Desabilitar protección csrf -> Statelest// Deshabilitar protección CSRF
        .authorizeHttpRequests(authRequest -> authRequest
            .requestMatchers(ADMIN_RESOURCES).hasAuthority(Role.ADMIN.name()) // Acceso solo para administradores
            .requestMatchers(TRAINER_RESOURCES).hasAuthority(Role.TRAINER.name()) // Acceso solo para entrenadores
            .requestMatchers(PUBLIC_RESOURCES).permitAll() // Rutas públicas
            .anyRequest().authenticated() // Otras rutas requieren autenticación
        )
        .sessionManagement(sessioManager -> sessioManager.sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Política
                                                                                                                 // de
                                                                                                                 // sesión
                                                                                                                 // sin
                                                                                                                 // estado
        )
        .authenticationProvider(this.authenticationProvider)
        .addFilterBefore(this.jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
        .build();
  }
}
