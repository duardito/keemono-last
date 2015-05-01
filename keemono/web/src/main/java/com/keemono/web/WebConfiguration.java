package com.keemono.web;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by edu on 18/04/2015.
 */
@EnableTransactionManagement
//@EnableJpaRepositories
@EnableMongoRepositories(basePackages = "com.keemono.domain.mongo.*.repository")
@PropertySource("classpath:config/mongo.properties")
@ComponentScan(basePackages = {"com.keemono.web","com.keemono.integration","com.keemono.core", "com.keemono.configuration.mongo"} )
//@Import({PropertyLoader.class,})
@Configuration
public interface WebConfiguration {

}
