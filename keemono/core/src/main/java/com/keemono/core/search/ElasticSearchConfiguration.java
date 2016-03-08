package com.keemono.core.search;

import org.elasticsearch.node.NodeBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * Created by edu on 05/03/2016.
 */
@Configuration
@EnableElasticsearchRepositories(basePackages = {"com.keemono.core.search.repository"})
public class ElasticSearchConfiguration {

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() {

        NodeBuilder builder = new NodeBuilder();
        builder.local(true);
        return new ElasticsearchTemplate(builder.build().client());
    }
}
