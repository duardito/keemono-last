package com.keemono.web;

import com.keemono.configuration.CommonConfiguration;
import com.keemono.configuration.PersistenceConfiguration;
import com.keemono.integration.configuration.IntegrationConfiguration;
import com.keemono.configuration.ServiceConfiguration;
import org.springframework.context.annotation.*;

/**
 * Created by edu on 18/04/2015.
 */
@PropertySources({
                @PropertySource(value = "classpath:config/mysql.properties"),
                @PropertySource("classpath:config/solr.properties"),
                @PropertySource("classpath:config/init.properties")
                })
@ComponentScan(basePackages = {"com.keemono.web","com.keemono.common","com.keemono.service"} )
@Import({PersistenceConfiguration.class, ServiceConfiguration.class, IntegrationConfiguration.class, CommonConfiguration.class})
@Configuration
public class WebConfiguration {


}
