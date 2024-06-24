package com.trainingDog.domain.entities;

import java.util.List;

import com.trainingDog.utils.enums.TrainingLevel;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class Dog {
   @Id
   @GeneratedValue (strategy = GenerationType.IDENTITY)
   private Long id;
   @Column(length = 100, nullable = false)
   private String name;
   @Column(length = 100, nullable = false)
   private String breed;
   @Column(length = 100, nullable = false)
   private Integer age;
   @Column(length = 100, nullable = false)
   @Enumerated(EnumType.STRING)
   private TrainingLevel trainingLevel;
   
   @ManyToOne
   @JoinColumn(name = "trainer_id" ,referencedColumnName = "id")
   private User trainer;

   
   @OneToMany(mappedBy = "dog", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
   private List<TrainingProgram> trainingPrograms;

   @OneToMany(mappedBy = "dog", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
   private List<Progress> progress;
}