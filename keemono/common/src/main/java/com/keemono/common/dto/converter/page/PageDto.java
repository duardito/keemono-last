package com.keemono.common.dto.converter.page;

import com.keemono.common.dto.converter.base.AbstractDto;

/**
 * Created by edu on 25/4/15.
 */
public class PageDto extends AbstractDto {
    private String layout;

    private String name;

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

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



}
