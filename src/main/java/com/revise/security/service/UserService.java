package com.revise.security.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.revise.security.util.SecurityUtils;
import com.revise.security.exception.UserAlreadyExistException;
import com.revise.security.model.User;
import com.revise.security.repository.AuthorityRepository;
import com.revise.security.repository.UserRepository;
import com.revise.security.controller.dto.RegisterDto;

import java.util.Collections;
import java.util.Optional;

@Service
@Transactional
public class UserService {

   private final UserRepository userRepository;

   private final AuthorityRepository authorityRepository;

   private final PasswordEncoder passwordEncoder;

   public UserService(UserRepository userRepository, AuthorityRepository authorityRepository, PasswordEncoder passwordEncoder) {
      this.userRepository = userRepository;
      this.authorityRepository = authorityRepository;
      this.passwordEncoder = passwordEncoder;
   }

   @Transactional(readOnly = true)
   public Optional<User> getUserWithAuthorities() {
      return SecurityUtils.getCurrentUsername().flatMap(userRepository::findOneWithAuthoritiesByUsername);
   }

   @Transactional
   public User addUser(RegisterDto registerDto) {

      if (userRepository.findByUsername(registerDto.getUsername()) != null) {
         throw new UserAlreadyExistException("Username already exist");
      }

      User user = new User();
      user.setUsername(registerDto.getUsername());
      user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
      user.setActivated(true);
      user.setAuthorities(Collections.singleton(authorityRepository.findByName("ROLE_USER")));
      return userRepository.save(user);
   }
}
