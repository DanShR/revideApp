package com.revise.exception;

public class CurrentUserNotFoundException extends RuntimeException {

   public CurrentUserNotFoundException() {
      super("Current user not found");
   }
}
