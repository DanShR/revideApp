package com.revise.exception;

import org.springframework.security.core.AuthenticationException;

public class RecipientNotFoundException extends RuntimeException {

   public RecipientNotFoundException() {
      super("Recipient not found");
   }
}
