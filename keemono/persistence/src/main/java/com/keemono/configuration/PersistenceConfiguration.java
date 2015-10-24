package com.keemono.configuration;


import com.keemono.configuration.mysql.SessionFactoryContext;
import com.keemono.configuration.solr.SolrConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by edu on 09/05/2015.
 */

@Import({SolrConfiguration.class, SessionFactoryContext.class})
@Configuration
public class PersistenceConfiguration {
}
