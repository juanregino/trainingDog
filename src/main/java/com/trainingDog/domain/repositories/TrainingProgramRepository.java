package com.trainingDog.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trainingDog.domain.entities.TrainingProgram;
@Repository
public interface TrainingProgramRepository extends JpaRepository<TrainingProgram, Long> {
  
}
