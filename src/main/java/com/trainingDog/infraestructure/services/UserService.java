package com.trainingDog.infraestructure.services;

import org.springframework.data.domain.Page;

import com.trainingDog.api.dto.request.UserRequest;
import com.trainingDog.api.dto.response.basic.UserBasicResponse;
import com.trainingDog.infraestructure.abstract_services.IUserService;

public class UserService implements IUserService {

  @Override
  public UserBasicResponse create(UserRequest request) {
    
    return null;
  }

  @Override
  public void delete(Long id) {
    
    
  }

  @Override
  public UserBasicResponse get(Long id) {
    
    return null;
  }

  @Override
  public Page<UserBasicResponse> getAll(int page, int size) {
    
    return null;
  }

  @Override
  public UserBasicResponse update(UserRequest request, Long id) {
    
    return null;
  }
  
}
