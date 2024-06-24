package com.trainingDog.infraestructure.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trainingDog.api.dto.request.TrainingProgramRequest;
import com.trainingDog.api.dto.response.basic.TrainingPBasicResponse;
import com.trainingDog.domain.entities.Dog;
import com.trainingDog.domain.entities.TrainingProgram;
import com.trainingDog.domain.entities.User;
import com.trainingDog.domain.repositories.DogRepository;
import com.trainingDog.domain.repositories.UserRepository;
import com.trainingDog.utils.exceptions.IdNotFoundException;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TrainingProgramMapper {
   @Autowired
   private final UserRepository userRepository;
   @Autowired
   private final DogRepository dogRepository;
  public TrainingPBasicResponse toResponse (TrainingProgram entity){
    return TrainingPBasicResponse.builder()
          .description(entity.getDescription())
          .id(entity.getId())
          .build();
  }

  public TrainingProgram  toEntity(TrainingProgramRequest request){
    Dog dog = this.dogRepository.findById(request.getDogId()).orElseThrow(()-> new IdNotFoundException("Dog not found", request.getDogId()));

    User user = this.userRepository.findById(request.getUserId()).orElseThrow(()-> new IdNotFoundException("User not found", request.getUserId()));
    return TrainingProgram.builder()
          .description(request.getDescription())
          .dog(dog) 
          .trainer(user)
          .build();
  }
}
