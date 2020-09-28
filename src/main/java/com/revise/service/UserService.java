package com.revise.service;

import com.revise.exception.PasswordConfirmException;
import com.revise.exception.VerificationTokenNotFoundException;
import com.revise.model.VerificationToken;
import com.revise.repository.VerificationTokenRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.revise.util.SecurityUtils;
import com.revise.exception.UserAlreadyExistException;
import com.revise.model.User;
import com.revise.repository.AuthorityRepository;
import com.revise.repository.UserRepository;
import com.revise.controller.dto.RegisterDto;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Optional;

@Service
@Transactional
public class UserService {

   private final UserRepository userRepository;

   private final AuthorityRepository authorityRepository;

   private final VerificationTokenRepository verificationTokenRepository;

   private final PasswordEncoder passwordEncoder;

   public UserService(UserRepository userRepository, AuthorityRepository authorityRepository, VerificationTokenRepository verificationTokenRepository, PasswordEncoder passwordEncoder) {
      this.userRepository = userRepository;
      this.authorityRepository = authorityRepository;
      this.verificationTokenRepository = verificationTokenRepository;
      this.passwordEncoder = passwordEncoder;
   }

   @Transactional(readOnly = true)
   public Optional<User> getUserWithAuthorities() {
      return SecurityUtils.getCurrentUsername().flatMap(userRepository::findOneWithAuthoritiesByUsername);
   }

   @Transactional
   public User addUser(RegisterDto registerDto) {

      if (!registerDto.getPassword().equals(registerDto.getPasswordConfirm())) {
         throw new PasswordConfirmException();
      }

      if (userRepository.findByUsername(registerDto.getUsername()) != null) {
         throw new UserAlreadyExistException();
      }

      User user = new User();
      user.setUsername(registerDto.getUsername());
      user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
      user.setEmail(registerDto.getEmail());
      user.setActivated(false);
      user.setAuthorities(Collections.singleton(authorityRepository.findByName("ROLE_USER")));
      return userRepository.save(user);
   }

    public void createVerificationTokenForUser(User user, String token) {
       VerificationToken verificationToken = new VerificationToken();
       verificationToken.setToken(token);
       verificationToken.setUser(user);
       verificationTokenRepository.save(verificationToken);
    }

    public void confirmRegistration(String token) {
       VerificationToken verificationToken = verificationTokenRepository.findByToken(token);
       if (verificationToken == null)
          throw new VerificationTokenNotFoundException();

       verificationToken.setActivationDate(LocalDateTime.now());
       verificationTokenRepository.save(verificationToken);

       User user = verificationToken.getUser();
       user.setActivated(true);
       userRepository.save(user);
    }
}
