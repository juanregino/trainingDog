package com.trainingDog.infraestructure.abstract_services;

import com.trainingDog.api.dto.request.TrainingProgramRequest;
import com.trainingDog.api.dto.response.basic.TrainingPBasicResponse;

public interface ITrainingProgramService  extends CrudService<TrainingProgramRequest, TrainingPBasicResponse, Long> {
  
}
