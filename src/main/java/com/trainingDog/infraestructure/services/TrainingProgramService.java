package com.trainingDog.infraestructure.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trainingDog.api.dto.request.TrainingProgramRequest;
import com.trainingDog.api.dto.response.basic.TrainingPBasicResponse;
import com.trainingDog.domain.entities.TrainingProgram;

import com.trainingDog.domain.repositories.TrainingProgramRepository;
import com.trainingDog.infraestructure.abstract_services.ITrainingProgramService;
import com.trainingDog.infraestructure.mappers.TrainingProgramMapper;
import com.trainingDog.utils.exceptions.IdNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TrainingProgramService implements ITrainingProgramService {
  @Autowired
  private final TrainingProgramMapper trainingProgramMapper;
  @Autowired
  private final TrainingProgramRepository trainingProgramRepository;
  @Override
  public TrainingPBasicResponse create(TrainingProgramRequest request) {
    TrainingProgram trainingProgram = this.trainingProgramMapper.toEntity(request);
    return this.trainingProgramMapper.toResponse(this.trainingProgramRepository.save(trainingProgram));
    
  }
  @Override
  public void delete(Long id) {
    TrainingProgram trainingProgram = this.find(id);
    this.trainingProgramRepository.delete(trainingProgram);
    
  }
  @Override
  public TrainingPBasicResponse get(Long id) {
    
    return this.trainingProgramMapper.toResponse(this.find(id));
  }
  @Override
  public List<TrainingPBasicResponse> getAll() {
    
    return this.trainingProgramRepository.findAll().stream().map(trainingProgramMapper::toResponse).toList();
  }
  @Override
  public TrainingPBasicResponse update(TrainingProgramRequest request, Long id) {
    TrainingProgram trainingProgram = this.find(id);
    trainingProgram.setId(id);
    return this.trainingProgramMapper.toResponse(this.trainingProgramRepository.save(trainingProgram));
    
  }
private TrainingProgram find(Long id) {

    return this.trainingProgramRepository.findById(id).orElseThrow(() -> new IdNotFoundException("Training Program not found" , id));

  }
  

}
