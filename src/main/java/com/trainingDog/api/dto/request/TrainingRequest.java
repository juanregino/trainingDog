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
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TrainingRequest {
  @NotBlank(message = "Training name is required")
  @Size(min = 1, max = 100, message = "Training name must be between 1 and 100 characters")
  private String name;
  @NotBlank(message = "Training description is required")
  @Size(min = 1, max = 255, message = "Training description must be between 1 and 255 characters")
  private String description;
  @NotNull(message = "Training level is required")
  private TrainingLevel trainingLevel;
}
 
 