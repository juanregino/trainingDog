package com.trainingDog.infraestructure.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trainingDog.api.dto.request.TrainingRequest;
import com.trainingDog.api.dto.response.basic.TrainingResponse;
import com.trainingDog.domain.entities.Training;

import com.trainingDog.domain.repositories.TrainingRepository;
import com.trainingDog.infraestructure.abstract_services.ITrainingService;
import com.trainingDog.infraestructure.mappers.TrainingMapper;
import com.trainingDog.utils.exceptions.IdNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TrainingService implements ITrainingService {
  @Autowired
  private final TrainingMapper trainingMapper;
  @Autowired
  private final TrainingRepository trainingRepository;
  @Override
  public TrainingResponse create(TrainingRequest request) {
    Training training = this.trainingMapper.toEntity(request);
    return this.trainingMapper.toResponse(this.trainingRepository.save(training));

  }
  @Override
  public void delete(Long id) {
    Training training = this.find(id);
    this.trainingRepository.delete(training);
    
  }
  @Override
  public TrainingResponse get(Long id) {
    
    return this.trainingMapper.toResponse(this.find(id));
  }
  @Override
  public List<TrainingResponse> getAll() {
    
    return this.trainingRepository.findAll().stream().map(trainingMapper::toResponse).toList();
  }
  @Override
  public TrainingResponse update(TrainingRequest request, Long id) {
    Training existingTraining = this.find(id);
    existingTraining.setId(id);
    return this.trainingMapper.toResponse(this.trainingRepository.save(existingTraining));
   
  }
    private Training find(Long id) {

    return this.trainingRepository.findById(id).orElseThrow(() -> new IdNotFoundException("User not found" , id));

  }
}
