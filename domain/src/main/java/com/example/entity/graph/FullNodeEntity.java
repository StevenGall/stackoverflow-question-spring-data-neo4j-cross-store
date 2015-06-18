
package com.example.entity.graph;

/**
 * @author sgall
 *
 */


import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;

@NodeEntity
public class FullNodeEntity{


  @GraphId Long graphId;

  /**
   * A free form text description
   */

  private String description;

  /**
   * The name given by the User
   */
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
