package com.keemono.core.mongo.domain.page;

import com.keemono.core.mongo.base.AbstractDocument;
import com.keemono.core.mongo.domain.layout.Layout;
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
