package com.trainingDog.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trainingDog.domain.entities.Progress;
@Repository
public interface ProgressRepository extends JpaRepository<Progress, Long> {
  
}
