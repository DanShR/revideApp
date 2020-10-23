package com.revise.mail;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import net.sargue.mailgun.Configuration;
import net.sargue.mailgun.Mail;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MailgunSender {

   private final MailgunConfig mailgunConfig;

   public void sendMail(VerificationMail verificationMail) {
      Mail.using(mailgunConfig.getConfiguration())
         .to(verificationMail.getEmailAdress())
         .subject(verificationMail.getSubject())
         .text(verificationMail.getText())
         .build()
         .send();
   }
}
