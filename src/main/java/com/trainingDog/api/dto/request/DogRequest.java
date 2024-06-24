package com.trainingDog.api.dto.request;

import com.trainingDog.utils.enums.TrainingLevel;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DogRequest {
  @NotBlank(message = "Name is required")
  @Size(min = 1, max = 100, message = "Name must be between 1 and 100 characters")
  private String name;

  @NotBlank(message = "Breed is required")
  @Size(min = 1, max = 100, message = "Breed must be between 1 and 100 characters")
  private String breed;
  @NotNull(message = "Age is required")
  private Integer age;
  @NotNull(message = "TrainingLevel is required")
  private TrainingLevel trainingLevel;
  @NotNull(message = "UserId is required")
  private Long userId;

}
