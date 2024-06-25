package com.trainingDog.infraestructure.abstract_services;

import com.trainingDog.api.dto.request.TrainingRequest;
import com.trainingDog.api.dto.response.basic.TrainingResponse;

public interface ITrainingService extends CrudService<TrainingRequest, TrainingResponse, Long> {
  
}
