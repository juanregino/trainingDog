package com.trainingDog.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trainingDog.domain.entities.EducationalResource;

public interface EducationalResourceRepository  extends JpaRepository<EducationalResource, Long> {
  
}
