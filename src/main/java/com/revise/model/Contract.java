package com.revise.model;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "contract")
@Data
public class Contract {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;

   @Column(name = "number")
   @NotNull
   private String number;

   @Column(name = "date")
   @NotNull
   private LocalDate date;

   @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
   @JoinColumn(name = "owner_id")
   private User owner;

   @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
   @JoinColumn(name = "company_id")
   private User company;

}
