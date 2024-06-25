package com.trainingDog.api.dto.response.basic;


import com.trainingDog.utils.enums.TrainingLevel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TrainingResponse {
  private Long id;
  private String name;
  private String description;
  private TrainingLevel trainingLevel;
}
