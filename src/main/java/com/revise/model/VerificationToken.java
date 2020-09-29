package com.revise.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "verification_token")
@Data
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

}
