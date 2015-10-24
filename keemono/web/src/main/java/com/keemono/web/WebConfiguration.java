package com.keemono.web;

import com.keemono.configuration.CommonConfiguration;
import com.keemono.configuration.PersistenceConfiguration;
import com.keemono.configuration.ServiceConfiguration;
import com.keemono.integration.configuration.IntegrationConfiguration;
import com.keemono.web.config.WebMvcConfig;
import com.keemono.web.swagger.SwaggerConfiguration;
import org.springframework.context.annotation.*;

/**
 * Created by edu on 18/04/2015.
 */
@PropertySources({
                @PropertySource("classpath:config/mysql.properties"),
                @PropertySource("classpath:config/solr.properties"),
                @PropertySource("classpath:config/init.properties"),
                @PropertySource(value = "classpath:config/test.properties",ignoreResourceNotFound = true)
                })
@ComponentScan(basePackages = {"com.keemono.web","com.keemono.common","com.keemono.service"} )
@Import({WebMvcConfig.class,PersistenceConfiguration.class, ServiceConfiguration.class, IntegrationConfiguration.class, CommonConfiguration.class, SwaggerConfiguration.class})
@Configuration
public class WebConfiguration {



}
