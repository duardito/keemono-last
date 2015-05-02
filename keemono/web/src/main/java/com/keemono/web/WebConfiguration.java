package com.keemono.web;

import org.springframework.context.annotation.*;

import com.keemono.configuration.mongo.MongoConnection;
import com.keemono.configuration.mysql.PersistenceContext;

/**
 * Created by edu on 18/04/2015.
 */
@PropertySources({@PropertySource(value = "classpath:config/mysql.properties"),
                @PropertySource("classpath:config/mongo.properties") })
@ComponentScan(basePackages = {"com.keemono.web","com.keemono.integration","com.keemono.core", "com.keemono.configuration.mongo"} )
@Import({PersistenceContext.class, MongoConnection.class})
@Configuration
public class WebConfiguration {


}
