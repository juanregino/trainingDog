package com.trainingDog.infraestructure.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trainingDog.api.dto.request.DogRequest;
import com.trainingDog.api.dto.response.basic.DogBasicResponse;
import com.trainingDog.domain.entities.Dog;
import com.trainingDog.domain.entities.User;
import com.trainingDog.domain.repositories.UserRepository;
import com.trainingDog.utils.exceptions.IdNotFoundException;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DogMapper {
 @Autowired 
 private final UserRepository userRepository;
  public DogBasicResponse toResponse (Dog entity ){
    return DogBasicResponse.builder()
        .id(entity.getId())
        .name(entity.getName())
        .breed(entity.getBreed())
        .age(entity.getAge())
        .trainingLevel(entity.getTrainingLevel().toString())
        .build();
  }

  public Dog toEntity ( DogRequest request){
    User user = this.userRepository.findById(request.getUserId()).orElseThrow(() -> new IdNotFoundException("User not found", request.getUserId()));  
    return Dog.builder()
        .name(request.getName())
        .breed(request.getBreed())
        .age(request.getAge())
        .trainingLevel(request.getTrainingLevel())
        .trainer(user)
        .build();

  }
}
