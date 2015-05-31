package com.keemono.core.solr;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

/**
 * Created by edu on 30/05/2015.
 */
@ComponentScan(basePackages = "com.keemono.core.solr")
@Configuration
@EnableSolrRepositories(basePackages = "com.keemono.core.solr.repository.*",multicoreSupport = true)
public class SolrCoreConfiguration {

}
