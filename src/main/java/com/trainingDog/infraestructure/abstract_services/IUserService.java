package com.trainingDog.infraestructure.abstract_services;

import com.trainingDog.api.dto.request.UserRequest;
import com.trainingDog.api.dto.response.basic.UserBasicResponse;

public interface IUserService  extends CrudService<UserRequest, UserBasicResponse, Long> {
  
}
