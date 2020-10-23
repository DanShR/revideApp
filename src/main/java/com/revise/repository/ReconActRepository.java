package com.revise.repository;

import com.revise.model.ReconAct;
import com.revise.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReconActRepository extends JpaRepository<ReconAct, Long> {
   Optional<ReconAct> getBySender(User user);
   List<ReconAct> findAll();
}
