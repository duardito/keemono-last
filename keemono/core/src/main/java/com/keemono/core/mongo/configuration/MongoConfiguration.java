package com.keemono.core.mongo.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by edu on 09/05/2015.
 */
@EnableMongoRepositories(basePackages = "com.keemono.core.mongo.repository")
@ComponentScan(basePackages = "com.keemono.core.mongo")
@Configuration
public class MongoConfiguration {
}
