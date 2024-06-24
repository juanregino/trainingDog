package com.trainingDog.domain.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Progress {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(nullable = false)
  private LocalDateTime date;
  @Column(length = 100, nullable = false)
  private String notes;
  
  @ManyToOne
  @JoinColumn(name = "training_program_id", referencedColumnName = "id")
  private TrainingProgram trainingProgram;

  @ManyToOne
  @JoinColumn(name = "dog_id", referencedColumnName = "id")
  private Dog dog;
}
