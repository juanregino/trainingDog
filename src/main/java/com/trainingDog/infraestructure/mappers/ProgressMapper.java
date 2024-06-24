package com.trainingDog.infraestructure.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trainingDog.api.dto.request.ProgressRequest;
import com.trainingDog.api.dto.response.basic.ProgressBasicResponse;
import com.trainingDog.domain.entities.Dog;
import com.trainingDog.domain.entities.Progress;
import com.trainingDog.domain.entities.TrainingProgram;
import com.trainingDog.domain.repositories.DogRepository;
import com.trainingDog.domain.repositories.TrainingProgramRepository;
import com.trainingDog.utils.exceptions.IdNotFoundException;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProgressMapper {
  @Autowired
  private final DogRepository dogRepository;
  @Autowired
  private final TrainingProgramRepository trainingProgramRepository;
  public ProgressBasicResponse toResponse(Progress progress){
    return ProgressBasicResponse.builder()
        .id(progress.getId())
        .date(progress.getDate())
        .notes(progress.getNotes())
        .build();
  }

  public Progress toEntity(ProgressRequest request){ 
    Dog dog = this.dogRepository.findById(request.getDogId()).orElseThrow(() -> new IdNotFoundException("Dog not found", request.getDogId()));

    TrainingProgram trainingProgram = this.trainingProgramRepository.findById(request.getTrainingProgramId()).orElseThrow(() -> new IdNotFoundException("Training Program not found", request.getTrainingProgramId()));
    return Progress.builder()
        .date(request.getDate())
        .notes(request.getNotes())
        .dog(dog)
        .trainingProgram(trainingProgram)
        .build();
  }
}
