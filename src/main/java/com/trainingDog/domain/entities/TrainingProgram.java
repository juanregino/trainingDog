package com.trainingDog.domain.entities;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TrainingProgram {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
   @Column(nullable = false)
  private LocalDateTime startDate;
  
  @ManyToOne
  @JoinColumn(name = "user_id" ,referencedColumnName = "id")
  private User trainer;

  @ManyToOne
  @JoinColumn(name = "dog_id" ,referencedColumnName = "id")
  private Dog dog;

  @OneToMany(mappedBy = "trainingProgram", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Progress> progress;

  @ManyToOne
  @JoinColumn(name = "training_id" ,referencedColumnName = "id")
  private Training training;

}
