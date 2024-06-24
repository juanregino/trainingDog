package com.trainingDog.api.dto.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.FutureOrPresent;
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
public class ProgressRequest {
  @FutureOrPresent(message = "Date must be in the future")
  private LocalDateTime date;
  @NotBlank(message = "Notes cannot be blank")
  @Size(max = 100, message = "Notes cannot be longer than 100 characters")
  private String notes;
  @NotNull(message = "Training program must be specified")
  private Long trainingProgramId;
  @NotNull(message = "Dog must be specified")
  private Long dogId;
}
