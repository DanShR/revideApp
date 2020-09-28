package com.revise.exception;

public class VerificationTokenNotFoundException extends RuntimeException{
   public VerificationTokenNotFoundException() {
      super("Token not found");
   }
}
