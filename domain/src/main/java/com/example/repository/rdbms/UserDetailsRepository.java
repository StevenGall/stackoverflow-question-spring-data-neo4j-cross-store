package com.example.repository.rdbms;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.entity.jpa.user.UserDetails;



/**
 * The repository for the UserDetails entity. This repository will be primarily used by spring security.
 * 
 * @author Steven Gall
 *
 */
public interface UserDetailsRepository extends CrudRepository<UserDetails, Long>{
  Optional<UserDetails> findByUserEmail(String email);
}
