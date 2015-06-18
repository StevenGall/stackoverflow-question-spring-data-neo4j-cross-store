package com.example.entity.jpa.user;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import com.example.entity.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * @author Steven Gall
 *
 */
@Entity
@Table(name = "user_details")
public class UserDetails extends AbstractEntity implements org.springframework.security.core.userdetails.UserDetails{

  /**
   * 
   */
  private static final long serialVersionUID = 6438722357739002649L;

  /**
   * The User this UserDetails entity is tied to.
   */
  @OneToOne
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  /**
   * The hashed password of a user.
   */
  // TODO determine if both length and @Size are needed
  @Column(name = "password", nullable = false, length = 60)
  @Size(max = 60)
  private String password;

  /**
   * If the user is enabled.
   */
  @Column(name = "enabled")
  @JsonIgnore
  private boolean enabled;

  /**
   * If the user has valid credentials.
   */
  @Column(name = "credentials_non_expired")
  @JsonIgnore
  private boolean credentialsNonExpired;

  /**
   * If the user is not blocked.
   */
  @Column(name = "account_non_locked")
  @JsonIgnore
  private boolean accountNonLocked;

  /**
   * If the user is not expired.
   */
  @Column(name = "account_non_expired")
  @JsonIgnore
  private boolean accountNonExpired;

  /*
   * (non-Javadoc)
   * 
   * @see org.springframework.security.core.userdetails.UserDetails#getAuthorities()
   */
  @Override
  @JsonIgnore
  public Collection<? extends GrantedAuthority> getAuthorities() {
    // TODO Auto-generated method stub
    return AuthorityUtils.commaSeparatedStringToAuthorityList(user.getRole().toString());
  }
  /*
   * (non-Javadoc)
   * 
   * @see org.springframework.security.core.userdetails.UserDetails#getPassword()
   */
  @Override
  @JsonIgnore
  public String getPassword() {
    return password;
  }
  /*
   * (non-Javadoc)
   * 
   * @see org.springframework.security.core.userdetails.UserDetails#getUsername()
   */
  @Override
  public String getUsername() {
    // TODO Auto-generated method stub
    return user.getEmail();
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonExpired()
   */
  @Override
  public boolean isAccountNonExpired() {
    return accountNonExpired;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonLocked()
   */
  @Override
  public boolean isAccountNonLocked() {
    return accountNonLocked;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.springframework.security.core.userdetails.UserDetails#isCredentialsNonExpired()
   */
  @Override
  public boolean isCredentialsNonExpired() {
    return credentialsNonExpired;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.springframework.security.core.userdetails.UserDetails#isEnabled()
   */
  @Override
  public boolean isEnabled() {
    return enabled;
  }

  /**
   * @param accountNonExpired the accountNonExpired to set
   */
  public void setAccountNonExpired(boolean accountNonExpired) {
    this.accountNonExpired = accountNonExpired;
  }

  /**
   * @param accountNonLocked the accountNonLocked to set
   */
  public void setAccountNonLocked(boolean accountNonLocked) {
    this.accountNonLocked = accountNonLocked;
  }

  /**
   * @param credentialsNonExpired the credentialsNonExpired to set
   */
  public void setCredentialsNonExpired(boolean credentialsNonExpired) {
    this.credentialsNonExpired = credentialsNonExpired;
  }
  /**
   * @param password the password to set
   */
  @JsonProperty
  @Required
  public void setPassword(String password) {
    this.password = password;
  }
  /**
   * @param enabled the enabled to set
   */
  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }
  /**
   * @return the user
   */
  public User getUser() {
    return user;
  }
  /**
   * @param user the user to set
   */
  public void setUser(User user) {
    this.user = user;
  }

}
