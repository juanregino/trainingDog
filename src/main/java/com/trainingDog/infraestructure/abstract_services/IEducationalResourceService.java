package com.trainingDog.infraestructure.abstract_services;

import com.trainingDog.api.dto.request.EducationalResourceReq;
import com.trainingDog.api.dto.response.basic.EducationalBasicResponse;

public interface IEducationalResourceService  extends CrudService<EducationalResourceReq, EducationalBasicResponse, Long> {
  
}
