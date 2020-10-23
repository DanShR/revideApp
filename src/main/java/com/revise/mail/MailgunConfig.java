package com.revise.mail;

import net.sargue.mailgun.Configuration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MailgunConfig {

   @Value("${mailgun.domain}")
   private String domain;

   @Value("${mailgun.apiKey}")
   private String apiKey;

   @Value("${mailgun.from.name}")
   private String name;

   @Value("${mailgun.from.email}")
   private String email;

   public Configuration getConfiguration() {
      Configuration configuration = new Configuration()
         .domain(domain)
         .apiKey(apiKey)
         .from(name, email);
      return configuration;
   }
}
