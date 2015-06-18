/**
 *
 * Date: Jun 12, 2015
 */
package com.example.api.config;

import org.neo4j.graphdb.GraphDatabaseService;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.cross_store.config.CrossStoreNeo4jConfiguration;
import org.springframework.data.neo4j.rest.SpringCypherRestGraphDatabase;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * @author Steven Gall
 *
 */
@Configuration
@EnableTransactionManagement(mode=AdviceMode.ASPECTJ)
@EnableNeo4jRepositories(basePackages = "com.example.repository.graph")
public class Neo4jConfig extends CrossStoreNeo4jConfiguration{
  
  Neo4jConfig(){
    setBasePackage("com.example.entity.graph");
  }
  
  @Bean(destroyMethod = "shutdown")
  public GraphDatabaseService graphDatabaseService(){
      return new SpringCypherRestGraphDatabase("http://localhost:7474/db/data","neo4j", "neo4j");

  }
  

}
