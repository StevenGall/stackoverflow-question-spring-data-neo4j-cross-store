
package com.example.entity.graph;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.GraphProperty;
import org.springframework.data.neo4j.annotation.NodeEntity;

import com.example.entity.AbstractEntity;


@Entity
@Table(name = "partial_entity")
@NodeEntity(partial = true)
public class PartialEntity extends AbstractEntity{

  @GraphId Long graphId;

  /**
   * A free form text description 
   */
  @Column(name = "description")
  @GraphProperty
  private String description;

  /**
   * The name given by the User
   */
  @Column(name = "name", nullable = false)
  @GraphProperty
  private String name;


  /**
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * @param description the description to set
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return the graphId
   */
  public Long getGraphId() {
    return graphId;
  }

  /**
   * @param graphId the graphId to set
   */
  public void setGraphId(Long graphId) {
    this.graphId = graphId;
  }

//  /**
//   * @return the owner
//   */
//  public User getOwner() {
//    return owner;
//  }
//
//  /**
//   * @param owner the owner to set
//   */
//  @Required
//  public void setOwner(User owner) {
//    this.owner = owner;
//  }
  
}
