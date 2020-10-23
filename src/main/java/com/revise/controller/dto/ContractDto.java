package com.revise.controller.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class ContractDto {
   @NotNull
   private String contractNumber;

   @NotNull
   private LocalDate contractDate;
}
