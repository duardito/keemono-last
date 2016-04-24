package com.keemono.common.converter.request.page;

import com.keemono.common.converter.base.ContentBuilder;

/**
 * Created by edu on 09/05/2015.
 */
public class PageContentBuilder extends ContentBuilder {

    public static PageContentBuilder aPage() {
        return new PageContentBuilder();
    }

    public PageContentBuilder withName(String name) {
        content.append(ContentBuilder.createKeyValue("name", name));
        return this;
    }

    public PageContentBuilder withLayout(String layout) {
        content.append(ContentBuilder.createKeyValue("layout", layout));
        return this;
    }

    public PageContentBuilder withCreator(Integer creator) {
        content.append(ContentBuilder.createKeyValue("creator", creator));
        return this;
    }
}
