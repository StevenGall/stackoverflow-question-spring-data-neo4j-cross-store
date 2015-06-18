package com.example;

import java.io.File;
import java.io.IOException;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;


@SpringBootApplication
public class ApiConfiguration {

  /**
   * Main entry point for the REST API of the application.
   * 
   * @param args Command line arguments.
   */
  public static void main(String[] args) {
    SpringApplication.run(ApiConfiguration.class, args);
  }

  @Bean
  @Profile("local")
  public EmbeddedServletContainerFactory servletContainer() {
    TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();

    Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
    Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();

    try {
      File keystore = new ClassPathResource("config/local/local.keystore").getFile();
      connector.setScheme("https");
      connector.setSecure(true);
      connector.setPort(8443);
      protocol.setSSLEnabled(true);
      protocol.setKeystoreFile(keystore.getAbsolutePath());
      protocol.setKeystorePass("changeit");
      protocol.setKeyAlias("tomcat");
    } catch (IOException ex) {
      throw new IllegalStateException("Unable to access keystore", ex);
    }

    tomcat.addAdditionalTomcatConnectors(connector);
    return tomcat;
  }
}
