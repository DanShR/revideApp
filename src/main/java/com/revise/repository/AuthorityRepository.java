package com.revise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.revise.model.Authority;

/**
 * Spring Data JPA repository for the {@link Authority} entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {
   Authority findByName(String name);
}
