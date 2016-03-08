package com.keemono.configuration;


import com.keemono.configuration.mysql.SessionFactoryContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by edu on 09/05/2015.
 */

@Import({ SessionFactoryContext.class})
@Configuration
public class PersistenceConfiguration {
}
