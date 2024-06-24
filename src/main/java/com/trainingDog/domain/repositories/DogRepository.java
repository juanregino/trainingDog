package com.trainingDog.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trainingDog.domain.entities.Dog;

public interface DogRepository  extends JpaRepository<Dog, Long> {
  
}
