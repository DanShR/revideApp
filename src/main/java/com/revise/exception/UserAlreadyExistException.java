package com.revise.exception;

public final class UserAlreadyExistException extends RuntimeException {

   private static final long serialVersionUID = 5861310537366287163L;

   public UserAlreadyExistException() {
      super("username already exists");
   }

}
