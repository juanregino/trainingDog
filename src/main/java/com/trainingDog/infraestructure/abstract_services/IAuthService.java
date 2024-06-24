package com.trainingDog.infraestructure.abstract_services;

import com.trainingDog.api.dto.request.LoginRequest;
import com.trainingDog.api.dto.request.UserRequest;
import com.trainingDog.api.dto.response.basic.AuthResponse;

public interface IAuthService {
  public AuthResponse login(LoginRequest request);

  public AuthResponse register(UserRequest request);


}

  
