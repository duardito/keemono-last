package com.keemono.core.solr.repository.layout;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.io.Serializable;

/**
 * Created by edu on 31/05/2015.
 */
@SolrDocument(solrCoreName = "number1")
public class Layout implements Serializable{

    @Id
    private String id;

    @Field
    private String body;

    @Field
    private String schema;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
