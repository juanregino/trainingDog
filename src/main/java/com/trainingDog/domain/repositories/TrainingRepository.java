package com.trainingDog.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trainingDog.domain.entities.Training;

public interface TrainingRepository  extends JpaRepository<Training, Long> {
  
}
