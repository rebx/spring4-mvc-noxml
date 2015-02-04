package com.rebx.spring.config;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@EnableWebMvc
@ComponentScan("com.rebx.spring")
public class WebMvcConfig extends WebMvcConfigurerAdapter {

  @Resource
  ObjectMapper objectMapper;

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/").setViewName("home");
  }

  @Override
  public void addFormatters(FormatterRegistry formatterRegistry) {

  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/resources/**").addResourceLocations("/resources");
  }

  @Override
  public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
    configurer.enable();
  }

  @Bean
  public ViewResolver configureViewResolver() {
    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

    viewResolver.setPrefix("/WEB-INF/views");
    viewResolver.setSuffix(".jsp");
    return viewResolver;
  }

  @Override
  public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
    converter.setObjectMapper(objectMapper);
    converters.add(converter);
    super.configureMessageConverters(converters);
  }

}
