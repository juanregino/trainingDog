package com.trainingDog.api.dto.request;

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
public class TrainingProgramRequest {
  @NotBlank(message = "Training program description is required")
@Size(min = 1, max = 255, message = "Training program description must be between 1 and 255 characters")
   private String description;

   @NotNull(message = "Training program start date is required")
   private Long userId;
   @NotNull(message = "Training program end date is required")
   private Long dogId;
   
}
