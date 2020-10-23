package com.revise.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "usr")
@Data
public class User {

   @JsonIgnore
   @Id
   @Column(name = "id")
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "username", length = 50, unique = true)
   @NotNull
   @Size(min = 4, max = 50)
   private String username;

   @JsonIgnore
   @Column(name = "password", length = 100)
   @NotNull
   @Size(min = 4, max = 100)
   private String password;

   @JsonIgnore
   @Column(name = "email", length = 50)
   @Size(min = 4, max = 50)
   private String email;

   @JsonIgnore
   @Column(name = "activated")
   private boolean activated;

   @ManyToMany(targetEntity = Authority.class, fetch = FetchType.EAGER)
   @JoinTable(
      name = "USR_AUTHORITY",
      joinColumns = {@JoinColumn(name = "usr_id", referencedColumnName = "id")},
      inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "name")})
   @BatchSize(size = 20)
   @JsonIgnore
   private Set<Authority> authorities = new HashSet<>();

   @OneToOne(targetEntity = VerificationToken.class, mappedBy = "user", fetch = FetchType.LAZY)
   @JsonIgnore
   private VerificationToken verificationToken;

}
