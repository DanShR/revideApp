package com.revise.repository;

import com.revise.model.User;
import com.revise.model.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {
   VerificationToken findByUser(User user);
   VerificationToken findByToken(String token);
}
