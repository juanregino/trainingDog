package com.trainingDog.infraestructure.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trainingDog.api.dto.request.EducationalResourceReq;
import com.trainingDog.api.dto.response.basic.EducationalBasicResponse;
import com.trainingDog.domain.entities.EducationalResource;

import com.trainingDog.domain.repositories.EducationalResourceRepository;
import com.trainingDog.infraestructure.abstract_services.IEducationalResourceService;
import com.trainingDog.infraestructure.mappers.EducationalResourceMapper;
import com.trainingDog.utils.exceptions.IdNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EducationalResourceService implements IEducationalResourceService {
@Autowired 
private final EducationalResourceMapper educationalResourceMapper;
 @Autowired
 private final EducationalResourceRepository educationalResourceRepository;
@Override
public EducationalBasicResponse create(EducationalResourceReq request) {
  EducationalResource educationalResource = this.educationalResourceMapper.toEntity(request);

  return this.educationalResourceMapper.toResponse(this.educationalResourceRepository.save(educationalResource));
}
@Override
public void delete(Long id) {
  EducationalResource educationalResource = this.find(id);
  this.educationalResourceRepository.delete(educationalResource);
  
}
@Override
public EducationalBasicResponse get(Long id) {
  
  return this.educationalResourceMapper.toResponse(this.find(id));
}
@Override
public List<EducationalBasicResponse> getAll() {
  
  return this.educationalResourceRepository.findAll().stream().map(this.educationalResourceMapper::toResponse).collect(Collectors.toList());
}
@Override
public EducationalBasicResponse update(EducationalResourceReq request, Long id) {
  EducationalResource educationalResource = this.find(id);
  educationalResource.setId(educationalResource.getId());
  return this.educationalResourceMapper.toResponse(this.educationalResourceRepository.save(educationalResource));
}
 private EducationalResource find(Long id) {

    return this.educationalResourceRepository.findById(id).orElseThrow(() -> new IdNotFoundException("Educationa Resource not found" , id));

  }
}