package com.trainingDog.domain.entities;

import com.trainingDog.utils.enums.TypeResource;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class EducationalResource {
   @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

   @Column(length = 100, nullable = false)
  private String title;
  @Column(length = 255, nullable = false)
  private String description;
  @Column(length = 15, nullable = false)
  @Enumerated(EnumType.STRING)
  private TypeResource typeResource;
  @Column(length = 255, nullable = false)
  private String url;
  
  @ManyToOne
  @JoinColumn(name = "user_id", referencedColumnName = "id")
  private User user;
}
