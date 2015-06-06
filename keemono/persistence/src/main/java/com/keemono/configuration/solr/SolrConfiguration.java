package com.keemono.configuration.solr;

import com.keemono.core.solr.SolrCoreConfiguration;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;

/**
 * Created by edu on 30/05/2015.
 */
@Import(SolrCoreConfiguration.class)
@Configuration
public class SolrConfiguration {

    @Autowired
    private Environment env;

    @Bean
    public SolrServer solrServer() {
        String solrHost = env.getProperty("solr.host");
        return new HttpSolrServer(solrHost);
    }
}
