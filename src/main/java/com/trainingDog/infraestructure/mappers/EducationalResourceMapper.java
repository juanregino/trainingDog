package com.trainingDog.infraestructure.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trainingDog.api.dto.request.EducationalResourceReq;
import com.trainingDog.api.dto.response.basic.EducationalBasicResponse;
import com.trainingDog.domain.entities.EducationalResource;
import com.trainingDog.domain.entities.User;
import com.trainingDog.domain.repositories.UserRepository;
import com.trainingDog.utils.exceptions.IdNotFoundException;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EducationalResourceMapper {
  @Autowired
  private final UserRepository userRepository;
  public EducationalBasicResponse toResponse (EducationalResource entity) {
   return EducationalBasicResponse.builder()
        .id(entity.getId())
        .title(entity.getTitle())
        .description(entity.getDescription())
        .typeResource(entity.getTypeResource().toString())
        .url(entity.getUrl())
        .build();
  } 

  public EducationalResource toEntity (EducationalResourceReq request) {
    User  user = userRepository.findById(request.getUserId()).orElseThrow(() -> new IdNotFoundException("Educational Resource not found", request.getUserId()));
    return EducationalResource.builder()
        .title(request.getTitle())
        .description(request.getDescription())
        .typeResource(request.getTypeResource())
        .url(request.getUrl())
        .user(user)
        .build();
  }
}
