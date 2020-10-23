package com.revise.service;

import com.revise.controller.dto.ContractDto;
import com.revise.model.Contract;
import com.revise.model.User;
import com.revise.repository.ContractRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class ContractService {

   private final ContractRepository contractRepository;

   public ContractService(ContractRepository contractRepository) {
      this.contractRepository = contractRepository;
   }

   public Contract addContract(User owner, User company, String number, LocalDate date) {
      Contract contract = new Contract();
      contract.setOwner(owner);
      contract.setCompany(company);
      contract.setNumber(number);
      contract.setDate(date);
      return contractRepository.save(contract);
   }

   public Contract getContractFromContractDto(ContractDto contractDto, User owner, User company ) {
      if (contractDto == null)
         return null;

      Contract contract = null;
      Optional<Contract> contractOptional = findContract(owner, company, contractDto.getContractNumber(), contractDto.getContractDate());
      if (contractOptional.isEmpty()) {
         contract = addContract(owner, company, contractDto.getContractNumber(), contractDto.getContractDate());
      } else {
         contract = contractOptional.get();
      }

      return  contract;
   }

   public Optional<Contract> findContract(User owner, User company, String number, LocalDate date) {
      return contractRepository.findContract(owner, company, number, date);
   }
}
