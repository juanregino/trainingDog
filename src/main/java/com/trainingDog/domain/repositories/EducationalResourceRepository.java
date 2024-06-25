package com.trainingDog.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trainingDog.domain.entities.EducationalResource;
@Repository
public interface EducationalResourceRepository  extends JpaRepository<EducationalResource, Long> {
  
}
