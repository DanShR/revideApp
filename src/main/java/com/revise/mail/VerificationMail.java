package com.revise.mail;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class VerificationMail {
   private String emailAdress;
   private String subject;
   private String text;
}
