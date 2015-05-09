package com.keemono.configuration;

import com.keemono.configuration.mongo.MongoConnection;
import com.keemono.configuration.mysql.PersistenceContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by edu on 09/05/2015.
 */
@Import({MongoConnection.class, PersistenceContext.class})
@Configuration
public class PersistenceConfiguration {
}
