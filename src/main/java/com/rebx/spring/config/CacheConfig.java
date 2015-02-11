package com.rebx.spring.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableCaching
public class CacheConfig {

  @Bean
  public EhCacheManagerFactoryBean ehCacheManagerFactoryBean() {
    EhCacheManagerFactoryBean ehCacheManagerFactoryBean =
        new EhCacheManagerFactoryBean();
    ehCacheManagerFactoryBean.setConfigLocation(new ClassPathResource(
        "ehcache.xml"));
    ehCacheManagerFactoryBean.setShared(true);
    return ehCacheManagerFactoryBean;
  }

  @Bean
  public CacheManager cacheManager() {
    EhCacheCacheManager ehCacheCacheManager = new EhCacheCacheManager();
    ehCacheCacheManager
        .setCacheManager(ehCacheManagerFactoryBean().getObject());
    return ehCacheCacheManager;
  }

}
