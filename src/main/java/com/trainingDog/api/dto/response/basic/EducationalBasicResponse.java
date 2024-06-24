package com.trainingDog.api.dto.response.basic;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class EducationalBasicResponse {
  private Long id;
  private String title;
  private String description;
  private String typeResource;
  private String url;

}
