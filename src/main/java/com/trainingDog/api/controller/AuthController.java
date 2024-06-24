package com.trainingDog.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trainingDog.api.dto.request.LoginRequest;
import com.trainingDog.api.dto.request.UserRequest;
import com.trainingDog.api.dto.response.basic.AuthResponse;
import com.trainingDog.infraestructure.abstract_services.IAuthService;


import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

  @Autowired
  private final IAuthService authService;

  @PostMapping(path = "/login")
  public ResponseEntity<AuthResponse> login(
      @Validated @RequestBody LoginRequest request) {
    return ResponseEntity.ok(this.authService.login(request));
  }

  @PostMapping(path = "/register")
  public ResponseEntity<AuthResponse> register(
      @Validated @RequestBody UserRequest request) {
    return ResponseEntity.ok(this.authService.register(request));
  }

 
}
