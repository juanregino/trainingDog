package com.trainingDog.infraestructure.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trainingDog.api.dto.request.DogRequest;
import com.trainingDog.api.dto.response.basic.DogBasicResponse;
import com.trainingDog.domain.entities.Dog;

import com.trainingDog.domain.repositories.DogRepository;
import com.trainingDog.infraestructure.abstract_services.IDogService;
import com.trainingDog.infraestructure.mappers.DogMapper;
import com.trainingDog.utils.exceptions.IdNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DogService implements IDogService{
  
  @Autowired
  private final DogRepository dogRepository;
  @Autowired
  private final DogMapper dogMapper;

  @Override
  public DogBasicResponse create(DogRequest request) {
    Dog dog = this.dogMapper.toEntity(request);
    return this.dogMapper.toResponse(this.dogRepository.save(dog));

  }

  @Override
  public void delete(Long id) {
    Dog dog = this.find(id);
    this.dogRepository.delete(dog);
    
  }

  @Override
  public DogBasicResponse get(Long id) {
    return this.dogMapper.toResponse(this.find(id));
  }

  @Override
  public List<DogBasicResponse> getAll() {
    
    return this.dogRepository.findAll().stream().map(dogMapper::toResponse).toList();
  }

  @Override
  public DogBasicResponse update(DogRequest request, Long id) {
    Dog existingDog = this.find(id);
    existingDog.setId(id);
    return this.dogMapper.toResponse(this.dogRepository.save(existingDog));
    
  }

   private Dog find(Long id) {

    return this.dogRepository.findById(id).orElseThrow(() -> new IdNotFoundException("Dog not found" , id));

  }


}
