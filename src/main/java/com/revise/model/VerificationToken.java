package com.revise.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "verification_token")
public class VerificationToken {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   private long id;

   @Column(name = "token")
   private String token;

   @OneToOne
   @MapsId
   private User user;

   @Column(name = "activation_date")
   private LocalDateTime activationDate;

   public VerificationToken() {
   }

   public LocalDateTime getActivationDate() {
      return activationDate;
   }

   public void setActivationDate(LocalDateTime activationDate) {
      this.activationDate = activationDate;
   }

   public User getUser() {
      return user;
   }

   public void setUser(User user) {
      this.user = user;
   }

   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public String getToken() {
      return token;
   }

   public void setToken(String token) {
      this.token = token;
   }
}
