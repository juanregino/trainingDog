package com.trainingDog.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trainingDog.domain.entities.Progress;

public interface ProgressRepository extends JpaRepository<Progress, Long> {
  
}
