package com.keemono.core.mysql.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by edu on 31/05/2015.
 */
@ComponentScan(basePackages = "com.keemono.core.mysql")
@EnableJpaRepositories(basePackages = "com.keemono.core.mysql.repository")
@Configuration
public class MysqlConfiguration {

}
