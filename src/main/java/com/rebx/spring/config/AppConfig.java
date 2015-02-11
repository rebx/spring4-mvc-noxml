package com.rebx.spring.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

@Configuration
@ComponentScan("com.rebx.spring")
public class AppConfig {

  private static final String APP_PROPERTIES = "app.properties";

  @Bean
  public static PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {

    final PropertyPlaceholderConfigurer propConfig =
        new PropertyPlaceholderConfigurer();

    propConfig.setIgnoreResourceNotFound(true);
    String sysPropPath = System.getProperty("app.cfg");

    if (sysPropPath != null) {
      propConfig.setLocation(new FileSystemResource(sysPropPath));
    } else {
      propConfig.setLocation(new ClassPathResource(APP_PROPERTIES));
    }
    return propConfig;
  }

}
