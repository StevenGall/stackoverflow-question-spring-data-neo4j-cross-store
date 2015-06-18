/**
 * Date: May 7, 2015
 */
package com.example.api.config;

import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * A configuration object for Spring Data.
 * 
 * @author David Caseria
 */
@Configuration
@EnableJpaAuditing
@EnableTransactionManagement(mode=AdviceMode.ASPECTJ)
@EnableJpaRepositories(basePackages = "com.example.repository.rdbms", entityManagerFactoryRef="entityManagerFactory", transactionManagerRef="transactionManager")
public class SpringDataConfig {

  // @Bean
  // public AuditorAware<AuditableUser> auditorProvider() {
  // return new AuditorAwareImpl();
  // }
}
