package com.me.movielogger.config;

import com.me.movielogger.dao.MovieCacheDao;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SpringConfig {

    @Bean
    public RestTemplate wireRestTemplate() {
        return new RestTemplate();
    }

//    @Bean
//    public HibernateTransactionManager transactionManager() {
//        SessionFactory sessionFactory;
//        return new HibernateTransactionManager();
//    }
}
