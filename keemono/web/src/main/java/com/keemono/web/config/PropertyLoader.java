package com.keemono.web.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by edu on 25/04/2015.
 */
@Configuration
public class PropertyLoader {
    @Bean
    public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
        PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
                ppc.setLocations(new ClassPathResource("config/init.properties"),
                        new ClassPathResource("config/mongo.properties"),
                        new ClassPathResource("config/mysql.properties"));
        return ppc;
    }
}
