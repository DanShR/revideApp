package com.revise.service;

import com.revise.controller.dto.ReconActDto;
import com.revise.exception.CurrentUserNotFoundException;
import com.revise.exception.RecipientNotFoundException;
import com.revise.model.Contract;
import com.revise.model.ReconAct;
import com.revise.model.User;
import com.revise.repository.ReconActRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ReconActService {
   private final ReconActRepository reconActRepository;

   private final ContractService contractService;

   private final UserService userService;

   public ReconActService(ReconActRepository reconActRepository,  ContractService contractService, UserService userService) {
      this.reconActRepository = reconActRepository;
      this.contractService = contractService;
      this.userService = userService;
   }

   @Transactional
   public void addReconAct(ReconActDto reconActDto) {

      Optional<User> sender = userService.getCurrentUser();
      if (sender.isEmpty())
         throw new CurrentUserNotFoundException();

      Optional<User> recipient = userService.findByUsername(reconActDto.getRecipient());
      if (recipient.isEmpty())
         throw new RecipientNotFoundException();

      Contract contract = contractService.getContractFromContractDto(reconActDto.getContract(), sender.get(), recipient.get());

      ReconAct reconAct = new ReconAct();
      reconAct.setSender(sender.get());
      reconAct.setRecipient(recipient.get());
      reconAct.setBeginDate(reconActDto.getBeginDate());
      reconAct.setEndDate(reconActDto.getEndDate());
      reconAct.setContract(contract);

      reconActRepository.save(reconAct);
   }

   public List<ReconAct> getAll() {
      Optional<User> sender = userService.getCurrentUser();
      if (sender.isEmpty())
         throw new CurrentUserNotFoundException();

      return reconActRepository.findAll();
   }
}
