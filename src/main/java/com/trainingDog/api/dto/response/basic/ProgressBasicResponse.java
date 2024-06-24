package com.trainingDog.api.dto.response.basic;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ProgressBasicResponse {
  private Long id;
  private LocalDateTime date;
  private String notes;
}
