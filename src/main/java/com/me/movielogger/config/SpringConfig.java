package com.me.movielogger.config;

import com.me.movielogger.dao.MovieCacheDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SpringConfig {

    @Bean
    public RestTemplate wireRestTemplate() {
        return new RestTemplate();
    }
    
}
