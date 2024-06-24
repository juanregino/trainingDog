package com.trainingDog.infraestructure.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trainingDog.api.dto.request.ProgressRequest;
import com.trainingDog.api.dto.response.basic.ProgressBasicResponse;
import com.trainingDog.domain.entities.Progress;
import com.trainingDog.domain.repositories.ProgressRepository;
import com.trainingDog.infraestructure.abstract_services.IProgressService;
import com.trainingDog.infraestructure.mappers.ProgressMapper;
import com.trainingDog.utils.exceptions.IdNotFoundException;

import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor
public class ProgressService implements IProgressService{
  
  @Autowired
  private final ProgressMapper progressMapper;
  @Autowired
  private final ProgressRepository progressRepository;
  @Override
  public ProgressBasicResponse create(ProgressRequest request) {
    Progress progress = this.progressMapper.toEntity(request);

    return this.progressMapper.toResponse(this.progressRepository.save(progress));
  }
  @Override
  public void delete(Long id) {
    Progress progress = this.find(id);
    this.progressRepository.delete(progress);
    
  }
  @Override
  public ProgressBasicResponse get(Long id) {
    
    return this.progressMapper.toResponse(this.find(id));
  }
  @Override
  public List<ProgressBasicResponse> getAll() {
    
    return this.progressRepository.findAll().stream().map(progressMapper::toResponse).collect(Collectors.toList());
  }
  @Override
  public ProgressBasicResponse update(ProgressRequest request, Long id) {
    Progress progressExisting = this.find(id);
    progressExisting.setId(id);

    return this.progressMapper.toResponse(this.progressRepository.save(progressExisting));
  }

  private Progress find(Long id) {

    return this.progressRepository.findById(id).orElseThrow(() -> new IdNotFoundException("Progress not found" , id)); 
  }
}
