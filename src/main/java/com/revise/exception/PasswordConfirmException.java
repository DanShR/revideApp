package com.revise.exception;

public class PasswordConfirmException extends RuntimeException {

   public PasswordConfirmException() {
      super("password and password confirmation do not match");
   }
}
