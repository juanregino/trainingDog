package com.trainingDog.api.dto.request;

import com.trainingDog.utils.enums.Role;

import jakarta.validation.constraints.Email;
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
public class UserRequest {
  @NotBlank(message = "Username cannot be blank")
  @Size(min = 3, max = 100, message = "Username must be between 3 and 100 characters")
  private String userName;

  @NotBlank(message = "Password cannot be blank")
  @Size(min = 3, max = 100, message = "Password must be between 3 and 100 characters")
  private String password;
  @Email(message = "Email is not valid")
  private String email;
  @NotBlank(message = "Full name cannot be blank")
  @Size(min = 3, max = 100, message = "Full name must be between 3 and 100 characters")
  private String fullName;
  @NotNull(message = "Role cannot be null")
  private Role role;
}
