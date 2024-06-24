package com.trainingDog.infraestructure.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.trainingDog.api.dto.request.UserRequest;
import com.trainingDog.api.dto.response.basic.UserBasicResponse;
import com.trainingDog.domain.entities.User;


import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserMapper {
@Autowired
  private final PasswordEncoder passwordEncoder;

  public UserBasicResponse toBasicResponse( User entity){
    return UserBasicResponse.builder()
        .id(entity.getId())
        .userName(entity.getUsername())
        .password(entity.getPassword())
        .email(entity.getEmail())
        .fullName(entity.getFullName())
        .role(entity.getRole().toString())
        .build();
  }

 public User toEntity(UserRequest request){
    return User.builder()
        .userName(request.getUserName())
        .password(this.passwordEncoder.encode(request.getPassword()))
        .email(request.getEmail())
        .fullName(request.getFullName())
        .role(request.getRole())
        .build();
}


}
