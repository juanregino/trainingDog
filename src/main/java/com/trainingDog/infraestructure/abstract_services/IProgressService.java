package com.trainingDog.infraestructure.abstract_services;

import com.trainingDog.api.dto.request.ProgressRequest;
import com.trainingDog.api.dto.response.basic.ProgressBasicResponse;

public interface IProgressService  extends CrudService<ProgressRequest, ProgressBasicResponse, Long> {
  
}
