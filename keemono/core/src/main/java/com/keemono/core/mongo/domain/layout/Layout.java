package com.keemono.core.mongo.domain.layout;

import com.keemono.core.mongo.base.AbstractDocument;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Created by edu on 09/05/2015.
 */
@Document(collection="layout")
public class Layout extends AbstractDocument {

    @Field(value = "schema")
    private String schema;

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }
}
