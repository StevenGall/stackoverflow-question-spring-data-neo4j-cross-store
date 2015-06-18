 
package com.example.entity.jpa.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Required;

import com.example.entity.AbstractEntity;

/**
 * The user entity.
 * 
 * @author David Caseria
 * @author Steven Gall
 */
@Entity
@Table(name = "user_profile")
public class User extends AbstractEntity{

  private static final long serialVersionUID = 53887647670812546L;

  /**
   * The first name of the user.
   */
  @Column(name = "first_name", nullable = false)
  @NotEmpty

  protected String firstName;

  /**
   * The last name of the user.
   */
  @Column(name = "last_name", nullable = false)
  @NotEmpty
  protected String lastName;

  /**
   * The email address of the user. This is used as a username.
   */
  @Column(name = "email", nullable = false, unique = true)
  @NotEmpty
  protected String email;

  /**
   * The role of the user.
   */
  @Column(name = "role", nullable = false)
  @Enumerated(EnumType.STRING)
  @NotNull
  protected Role role;
  
  /**
   * @return the email
   */
  public String getEmail() {
    return email;
  }

  /**
   * @return the firstName
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * @return the lastName
   */
  @Required
  public String getLastName() {
    return lastName;
  }


  /**
   * @return the role
   */
  public Role getRole() {
    return role;
  }

 
  /**
   * @param email the email to set
   */
  @Required
  public void setEmail(String email) {
    this.email = email;
  }



  /**
   * @param firstName the firstName to set
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * @param lastName the lastName to set
   */
  @Required
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }


  /**
   * @param role the role to set
   */
  public void setRole(Role role) {
    this.role = role;
  }
}
