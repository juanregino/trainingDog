package com.trainingDog.api.dto.response.basic;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class UserBasicResponse {
  private Long id;
  private String userName;
  private String password;
  private String fullName;
  private String email;
   private String role;
}
