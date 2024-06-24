package com.trainingDog.infraestructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.stereotype.Service;

import com.trainingDog.api.dto.request.LoginRequest;
import com.trainingDog.api.dto.request.UserRequest;
import com.trainingDog.api.dto.response.basic.AuthResponse;
import com.trainingDog.domain.entities.User;
import com.trainingDog.domain.repositories.UserRepository;
import com.trainingDog.infraestructure.abstract_services.IAuthService;
import com.trainingDog.infraestructure.helpers.JwtService;
import com.trainingDog.infraestructure.mappers.UserMapper;

import com.trainingDog.utils.exceptions.BadRequestException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthService implements IAuthService {
  @Autowired
  private final UserRepository userRepository;
  @Autowired
  private final JwtService jwtService;
  // Interfaz que contiene los servicio de codificación
  
  @Autowired
  private final AuthenticationManager authenticationManager;
  @Autowired
  private final UserMapper userMapper;

  @Override
  public AuthResponse login(LoginRequest request) {

    try {
      // Autenticarnos en la app
      authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword()));
    } catch (Exception e) {
      throw new BadRequestException("Credenciales incorrectas");
    }

    User user = this.findUser(request.getUserName());

    return AuthResponse.builder()
        .message("Autenticado correctamente")
        .token(this.jwtService.getToken(user))
        .build();
  }

  @Override
  public AuthResponse register(UserRequest request) {
    /* 1. Validar que el usuario no existe */
    User exist = this.findUser(request.getUserName());

    if (exist != null) {
      throw new BadRequestException("El usuario ya existe");
    }

    /* Construir el usuario */
   User user = this.userMapper.toEntity(request);

    /** Guardamos el user en la db */
    user = this.userRepository.save(user);

    return AuthResponse.builder()
        .message("Registro completado exitosamente")
        .token(this.jwtService.getToken(user))
        .build();

  }

  private User findUser(String username) {
    return this.userRepository.findByUserName(username)
        .orElse(null);
  }

  }