package com.keemono.core.mysql.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by edu on 31/05/2015.
 */

@EnableJpaRepositories(basePackages = "com.keemono.core.mysql.Repository.*")
@Configuration
public class MysqlConfiguration {

}
