package com.trainingDog.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trainingDog.domain.entities.TrainingProgram;

public interface TrainingProgramRepository extends JpaRepository<TrainingProgram, Long> {
  
}
