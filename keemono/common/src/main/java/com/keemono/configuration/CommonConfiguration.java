package com.keemono.configuration;

import com.keemono.common.converter.request.layout.LayoutRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by edu on 09/05/2015.
 */
@ComponentScan(basePackages = "com.keemono.common")
@Configuration
public class CommonConfiguration {

    @Bean
    public LayoutRequest layoutRequest(){
        return new LayoutRequest();
    }
}
