package com.keemono.domain.mongo.page;

import com.keemono.domain.mongo.base.AbstractDocument;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Created by edu on 25/4/15.
 */
@Document(collection="pages")
public class Page extends AbstractDocument {

    @DBRef
    private Layout layout;

    @Field("name")
    private String name;

    @Field("url")
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Layout getLayout() {
        return layout;
    }

    public void setLayout(Layout layout) {
        this.layout = layout;
    }
}
