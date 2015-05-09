package com.keemono.common.converter.response.page;

import com.keemono.common.converter.base.AbstractResponse;

/**
 * Created by edu on 25/04/2015.
 */
public class PageResponse extends AbstractResponse {

    private String id;
    private String layout;
    private String name;
    private String url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

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
}
