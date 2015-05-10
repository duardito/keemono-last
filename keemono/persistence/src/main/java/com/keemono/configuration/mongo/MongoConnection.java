package com.keemono.configuration.mongo;

import com.keemono.core.mongo.configuration.MongoConfiguration;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

/**
 * Created by edu on 25/4/15.
 */
@Import({MongoConfiguration.class})
@Configuration
public class MongoConnection {

    @Autowired
    private Environment environment;

    @Bean
    public MongoDbFactory mongoDbFactory() throws Exception {

        String port = environment.getProperty("db.port");
        String dbName = environment.getProperty("db.name");
        String user= environment.getProperty("db.user");
        String passwd = environment.getProperty("db.password");
        String host = environment.getProperty("db.host");

        final UserCredentials userCredentials = new UserCredentials(user,passwd);
        final MongoClient client = new MongoClient(host,Integer.parseInt(port));
        return new SimpleMongoDbFactory(client, dbName, userCredentials);
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongoDbFactory());
    }
}
