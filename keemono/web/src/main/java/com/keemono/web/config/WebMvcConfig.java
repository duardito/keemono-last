package com.keemono.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;


/**
 * Created by edu on 18/4/15.
 */

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.keemono.integration", useDefaultFilters = false,
        includeFilters = {@ComponentScan.Filter(RestController.class),@ComponentScan.Filter(Controller.class)})
public class WebMvcConfig extends WebMvcConfigurationSupport {

    @Override
    public void configureDefaultServletHandling(final DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
