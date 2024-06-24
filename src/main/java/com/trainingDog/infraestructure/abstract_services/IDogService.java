package com.trainingDog.infraestructure.abstract_services;

import com.trainingDog.api.dto.request.DogRequest;
import com.trainingDog.api.dto.response.basic.DogBasicResponse;

public interface IDogService extends CrudService<DogRequest, DogBasicResponse, Long> {
  
}
