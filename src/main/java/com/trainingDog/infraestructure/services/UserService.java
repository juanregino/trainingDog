package com.trainingDog.infraestructure.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.trainingDog.api.dto.request.UserRequest;
import com.trainingDog.api.dto.response.basic.UserBasicResponse;
import com.trainingDog.domain.entities.User;
import com.trainingDog.domain.repositories.UserRepository;
import com.trainingDog.infraestructure.abstract_services.IUserService;
import com.trainingDog.infraestructure.mappers.UserMapper;
import com.trainingDog.utils.exceptions.IdNotFoundException;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
  @Autowired
  private final UserRepository userRepository;
  @Autowired
  private final UserMapper userMapper;
  @Override
  public UserBasicResponse create(UserRequest request) {
    User user = userMapper.toEntity(request);
    
    return this.userMapper.toBasicResponse(userRepository.save(user));
  }

  @Override
  public void delete(Long id) {
    User user = this.find(id);

    this.userRepository.delete(user);
    
  }

  @Override
  public UserBasicResponse get(Long id) {
    
    return null;
  }

  @Override
  public List<UserBasicResponse> getAll() {
    
   return this.userRepository.findAll().stream().map(userMapper::toBasicResponse).toList();
  }

  @Override
  public UserBasicResponse update(UserRequest request, Long id) {
    User existingUser = this.find(id);
    existingUser.setId(id);
    return this.userMapper.toBasicResponse(this.userRepository.save(existingUser));
  }

  private User find(Long id) {

    return this.userRepository.findById(id).orElseThrow(() -> new IdNotFoundException("User not found" , id));

  }
  
}
