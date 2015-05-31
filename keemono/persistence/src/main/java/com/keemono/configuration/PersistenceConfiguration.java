package com.keemono.configuration;

<<<<<<< Updated upstream
import com.keemono.configuration.mongo.MongoConnection;
import com.keemono.configuration.mysql.PersistenceContext;
=======
import com.keemono.configuration.mysql.SessionFactoryContext;
import com.keemono.configuration.solr.SolrConfiguration;
>>>>>>> Stashed changes
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by edu on 09/05/2015.
 */
<<<<<<< Updated upstream
@Import({MongoConnection.class, PersistenceContext.class})
=======
@Import({SolrConfiguration.class, SessionFactoryContext.class})
>>>>>>> Stashed changes
@Configuration
public class PersistenceConfiguration {
}
