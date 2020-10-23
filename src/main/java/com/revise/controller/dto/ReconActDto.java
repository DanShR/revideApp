package com.revise.controller.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class ReconActDto {

   @NotNull
   private String recipient;

   @NotNull
   private LocalDate beginDate;

   @NotNull
   private LocalDate endDate;

   private ContractDto contract;
}
