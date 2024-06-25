package com.trainingDog.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trainingDog.domain.entities.Dog;
@Repository
public interface DogRepository  extends JpaRepository<Dog, Long> {
  
}
