 
package com.example.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.entity.jpa.user.User;
import com.example.entity.jpa.user.UserDetails;

/**
 * A service for the User entity.
 * 
 * @author David Caseria
 * @author Steven Gall
 */
public interface UserService extends UserDetailsService {
  /**
   * This method is intended to be used when first creating a user entity. It is necessary to assoicated a User Details at the time of User creation so the application user has authentication and authorization permissions through spring security
   * 
   * @param user the user to create within our system
   * @param userDetails the user details as required by spring security for authorization and authentication
   * @return
   */
  Optional<User> create(User user, UserDetails userDetails);
  /**
   * Finds a user based on their email address
   * 
   * @param email the user's email address
   * @return returns an optional, the optional will be empty if a user can't be found that contains the email provided. If a user is found with the provided email, it will be present within the optional.
   */
  Optional<User> findUserByEmail(String email);
}
