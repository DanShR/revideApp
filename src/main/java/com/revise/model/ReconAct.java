package com.revise.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "reconciliation_act")
@Data
@NoArgsConstructor
public class ReconAct {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;

   @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
   @JoinColumn(name = "sender_id")
   @NotNull
   private User sender;

   @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
   @JoinColumn(name = "recipient_id")
   @NotNull
   private User recipient;

   @Column(name = "begin_date")
   @NotNull
   private LocalDate beginDate;

   @Column(name = "end_date")
   @NotNull
   private LocalDate endDate;

   @ManyToOne(targetEntity = Contract.class, fetch = FetchType.EAGER)
   @JoinColumn(name = "contract_id")
   @JsonIgnore
   private Contract contract;

}
