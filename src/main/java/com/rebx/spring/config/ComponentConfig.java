package com.rebx.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperFactoryBean;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class ComponentConfig {

  @Bean
  public ObjectMapper objectMapper() {
    Jackson2ObjectMapperFactoryBean bean = new Jackson2ObjectMapperFactoryBean();
    bean.setIndentOutput(true);
    bean.afterPropertiesSet();
    ObjectMapper objectMapper = bean.getObject();
    return objectMapper;
  }

}
