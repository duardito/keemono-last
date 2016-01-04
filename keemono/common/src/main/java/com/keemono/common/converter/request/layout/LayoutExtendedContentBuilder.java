package com.keemono.common.converter.request.layout;

import com.keemono.common.converter.base.ContentBuilder;

/**
 * Created by edu on 02/01/2016.
 */
public class LayoutExtendedContentBuilder extends ContentBuilder {

    public static LayoutExtendedContentBuilder aLayout() {
        return new LayoutExtendedContentBuilder();
    }

    public LayoutExtendedContentBuilder withSchema(String schema) {
        content.append(ContentBuilder.createKeyValue("schema", schema));
        return this;
    }


    public LayoutExtendedContentBuilder withName(String name) {
        content.append(ContentBuilder.createKeyValue("name", name));
        return this;
    }


    public LayoutExtendedContentBuilder withCreator(String creator) {
        content.append(ContentBuilder.createKeyValue("creator", creator));
        return this;
    }
}
