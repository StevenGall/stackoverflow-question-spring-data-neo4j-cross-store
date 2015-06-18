/**

 * Date: Jun 2, 2015
 */
package com.example.repository.graph;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.entity.graph.PartialEntity;

/**
 * @author Steven Gall
 *
 */
public interface PartialEntityRepository extends CrudRepository<PartialEntity, Long>{

  
  /**
   * Query to find one  by ID
   * 
   * @param id the id to retrieve
   * @return returns a entity wrapped by an Optional object
   */
  Optional<PartialEntity> findOneById(long id);
}
