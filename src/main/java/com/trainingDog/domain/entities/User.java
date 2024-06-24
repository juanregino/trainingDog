package com.trainingDog.domain.entities;

import java.util.List;

import com.trainingDog.utils.enums.Role;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Column(length = 100, nullable = false, unique = true)
  private String userName;
  
  @Column(length = 100, nullable = false)
  private String password;

  @Column(length = 100, nullable = false)
  private String fullName;

  @Column(length = 100, nullable = false)
  private String email;
 
  @Column(length = 15, nullable = false)
  @Enumerated(EnumType.STRING)
  private Role role;

  @OneToMany(mappedBy = "trainer", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
  private List<TrainingProgram> trainingPrograms;
  
  @OneToMany(mappedBy = "trainer", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Dog> dogs;

  @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
  private List<EducationalResource> educationalResources;

}
