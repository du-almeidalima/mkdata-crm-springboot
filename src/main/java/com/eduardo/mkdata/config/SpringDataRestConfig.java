package com.eduardo.mkdata.config;

import com.eduardo.mkdata.model.Customer;
import com.eduardo.mkdata.model.CustomerGroup;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.stereotype.Component;

@Component
public class SpringDataRestConfig implements RepositoryRestConfigurer {


  public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {

    // Habilitando CORS
    config.getCorsRegistry()
      .addMapping("/api/**")
      .allowedOrigins("*")
      .allowedMethods("POST", "OPTIONS", "GET", "DELETE", "PUT", "PATCH")
      .allowedHeaders("X-Requested-With", "Origin", "Content-Type", "Accept", "Authorization")
      .allowCredentials(true)
      .maxAge(3600);

    // Expondo ID's
    config.exposeIdsFor(Customer.class, CustomerGroup.class);
  }

}
