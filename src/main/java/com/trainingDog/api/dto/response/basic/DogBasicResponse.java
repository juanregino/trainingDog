package com.trainingDog.api.dto.response.basic;



import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class DogBasicResponse {
  private Long id;
  private String name;
  private String breed;
  private Integer age;
  private String trainingLevel;
  
}
