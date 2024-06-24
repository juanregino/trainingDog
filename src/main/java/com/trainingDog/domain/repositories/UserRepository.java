package com.trainingDog.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trainingDog.domain.entities.User;

public interface UserRepository  extends  JpaRepository<User, Long> {
  
}
