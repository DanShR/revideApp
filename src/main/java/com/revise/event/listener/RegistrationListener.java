package com.revise.event.listener;

import com.revise.event.OnRegistrationCompleteEvent;
import com.revise.model.User;
import com.revise.service.UserService;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.UUID;


@Component
public class RegistrationListener implements ApplicationListener<OnRegistrationCompleteEvent> {

   private UserService userService;

   private JavaMailSender mailSender;

   private Environment env;

   public RegistrationListener(UserService userService, JavaMailSender mailSender, Environment env) {
      this.userService = userService;
      this.mailSender = mailSender;
      this.env = env;
   }

   @Override
   public void onApplicationEvent(final OnRegistrationCompleteEvent event) {
      this.confirmRegistration(event);
   }

   private void confirmRegistration(final OnRegistrationCompleteEvent event) {
      final User user = event.getUser();
      final String token = UUID.randomUUID().toString();
      userService.createVerificationTokenForUser(user, token);

      final SimpleMailMessage email = constructEmailMessage(user, token);
      mailSender.send(email);
   }

   //

   private SimpleMailMessage constructEmailMessage(final User user, final String token) {
      final String subject = "Registration Confirmation";
      final String confirmationUrl = "http://localhost:8080/api/confirm?token=" + token;
      final String message = "You registered successfully. To confirm your registration, please click on the below link. ";

      final SimpleMailMessage email = new SimpleMailMessage();
      email.setTo(user.getEmail());
      email.setSubject(subject);
      email.setText(message + " \r\n" + confirmationUrl);
      email.setFrom(env.getProperty("support.email"));

      return email;
   }


}
