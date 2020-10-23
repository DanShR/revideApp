package com.revise.event.listener;

import com.revise.event.OnRegistrationCompleteEvent;
import com.revise.mail.MailgunSender;
import com.revise.mail.VerificationMail;
import com.revise.model.User;
import com.revise.service.UserService;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;


@Component
public class RegistrationListener implements ApplicationListener<OnRegistrationCompleteEvent> {

   private UserService userService;

   private MailgunSender mailgunSender;

   public RegistrationListener(UserService userService, MailgunSender mailgunSender) {
      this.userService = userService;
      this.mailgunSender = mailgunSender;
   }

   @Override
   public void onApplicationEvent(final OnRegistrationCompleteEvent event) {
      this.confirmRegistration(event);
   }

   private void confirmRegistration(final OnRegistrationCompleteEvent event) {
      final User user = event.getUser();
      final String token = UUID.randomUUID().toString();
      userService.createVerificationTokenForUser(user, token);

      final VerificationMail verificationMail = constructVerificationMail(user, token);
      mailgunSender.sendMail(verificationMail);

   }


   private VerificationMail constructVerificationMail(final User user, final String token) {
      final String subject = "Registration Confirmation";
      final String confirmationUrl = "http://localhost:8080/api/confirm?token=" + token;
      final String text = "You registered successfully. To confirm your registration, please click on the below link. ";
      return new VerificationMail(user.getEmail(), subject, text + " \r\n" + confirmationUrl);
   }




}
