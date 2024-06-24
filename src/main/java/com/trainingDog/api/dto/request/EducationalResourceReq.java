package com.trainingDog.api.dto.request;

import com.trainingDog.utils.enums.TypeResource;

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
public class EducationalResourceReq {
  @NotBlank(message = "title is required")
  @Size(min = 1, max = 100, message = "title must be between 1 and 100 characters")
  private String title;
  @NotBlank(message = "description is required")
  @Size(min = 1, max = 255, message = "description must be between 1 and 255 characters")
  private String description;
  @NotNull(message = "typeResource is required")
    private TypeResource typeResource;
    @NotBlank(message = "url is required")  
    @Size(min = 1, max = 255, message = "url must be between 1 and 255 characters")
    private String url;
    @NotNull(message = "userId is required")
    private Long userId;
}
