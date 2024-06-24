package com.trainingDog.domain.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trainingDog.domain.entities.User;

public interface UserRepository  extends  JpaRepository<User, Long> {
  public Optional<User> findByUserName(String username);
}
