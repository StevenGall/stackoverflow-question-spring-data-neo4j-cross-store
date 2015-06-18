 
package com.example.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.service.UserService;

/**
 * A configuration object for Spring Security.
 * 
 * @author David Caseria
 */
@EnableWebSecurity
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

  /**
   * Environment configuration properties.
   */
  @Autowired
  private Environment env;

  /**
   * User Service to encode passwords.
   */
  @Autowired
  private UserService userService;

  /*
   * (non-Javadoc)
   * 
   * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.
   * springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder)
   */
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.
   * springframework.security.config.annotation.web.builders.HttpSecurity)
   */
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.httpBasic().and().authorizeRequests().antMatchers("/resources/**", "/signup", "/users", "/users/test").permitAll()
        .anyRequest().authenticated().and().formLogin().usernameParameter("email").permitAll().and().logout()
        .logoutUrl("/logout").logoutSuccessUrl("/").permitAll().and().csrf().disable();
  }
}
