package com.trainingDog.infraestructure.mappers;

import org.springframework.stereotype.Component;

import com.trainingDog.api.dto.request.TrainingRequest;
import com.trainingDog.api.dto.response.basic.TrainingResponse;
import com.trainingDog.domain.entities.Training;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TrainingMapper {
  public TrainingResponse toResponse(Training entity){

    return TrainingResponse.builder()
        .id(entity.getId())
        .name(entity.getName())
        .description(entity.getDescription())
        .trainingLevel(entity.getTrainingLevel())
        .build();
  }

  public Training toEntity(TrainingRequest request){
    return Training.builder()
        .name(request.getName())
        .description(request.getDescription())
        .trainingLevel(request.getTrainingLevel())
        .build();
  }
}
