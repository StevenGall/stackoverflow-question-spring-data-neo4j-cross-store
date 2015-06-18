 
package com.example.service.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.entity.jpa.user.Role;
import com.example.entity.jpa.user.User;
import com.example.entity.jpa.user.UserDetails;
import com.example.repository.rdbms.UserDetailsRepository;
import com.example.repository.rdbms.UserRepository;
import com.example.service.UserService;

/**
 * 
 * @author Steven Gall
 * @author David Caseria
 */
@Service("userService")
public class UserServiceImpl implements UserService {

  private static final Logger LOG = LogManager.getLogger(UserServiceImpl.class);

  /**
   * The repository containing the user details to be used by the spring security module
   */
  @Autowired
  private UserDetailsRepository userDetailsRepository;

  /**
   * The repository containing the general user information to be used throughout the application
   */
  @Autowired
  private UserRepository userRepository;

  /*
   * (non-Javadoc)
   * 
   * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
   */
  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    Optional<UserDetails> user = userDetailsRepository.findByUserEmail(email);
    if (user.isPresent()) {
      LOG.debug("loading user: " + user.toString());
      return user.get();
    }
    LOG.debug("Email'" + email + "' was not found");
    throw new UsernameNotFoundException(email);
  }


  // TODO Error Handling
  @Transactional
  public Optional<User> create(User user, UserDetails userDetails) {
    if (null != user) {
      user.setRole(Role.USER);
      user = userRepository.save(user);
      userDetails.setUser(user);
      userDetails.setPassword(new BCryptPasswordEncoder().encode(userDetails.getPassword()));
      userDetails.setAccountNonExpired(true);
      userDetails.setAccountNonLocked(true);
      userDetails.setCredentialsNonExpired(true);
      userDetails.setEnabled(true);
    }

    LOG.debug(user);
    return Optional.ofNullable(user);
  }


  /* (non-Javadoc)
   * @see com.example.service.UserService#findUserByEmail(java.lang.String)
   */
  @Override
  public Optional<User> findUserByEmail(String email) {
    Optional<User> user = userRepository.findOneByEmail(email);
    LOG.debug("Email '"+email+"' returned" + user.toString());
    return user;
  }
}
