package com.revise.repository;

import com.revise.model.Contract;
import com.revise.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Optional;

public interface ContractRepository extends JpaRepository<Contract, Long> {
   @Query("from Contract c where " +
      "c.owner=:owner " +
      "and c.company=:company " +
      "and c.number=:number " +
      "and c.date=:date")
   Optional<Contract> findContract(User owner, User company, String number, LocalDate date);
}
