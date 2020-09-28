package com.revise.controller.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * DTO for storing a user's credentials.
 */
public class RegisterDto {

   @NotNull
   @Size(min = 1, max = 50)
   private String username;

   @NotNull
   @Size(min = 4, max = 100)
   private String password;

   @NotNull
   @Size(min = 4, max = 100)
   private String passwordConfirm;

   @NotNull
   @Email
   private String email;

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getPasswordConfirm() {
      return passwordConfirm;
   }

   public void setPasswordConfirm(String passwordConfirm) {
      this.passwordConfirm = passwordConfirm;
   }

   @Override
   public String toString() {
      return "LoginVM{" +
         "username='" + username + '\'' +
         '}';
   }
}
