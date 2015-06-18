package com.example.repository.rdbms;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.entity.jpa.user.User;

/**
 * The repository for the User entity.
 * 
 * @author David Caseria
 * @author Steven Gall
 */
public interface UserRepository extends CrudRepository<User, Long> {

  /**
   * Query to find a user by email address.
   * 
   * @param email the email address to search
   * @return the user wrapped in an Optional class
   */
  Optional<User> findOneByEmail(String email);
}
