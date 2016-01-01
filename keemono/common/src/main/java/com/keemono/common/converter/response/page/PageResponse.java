package com.keemono.common.converter.response.page;

import com.keemono.common.converter.base.AbstractResponse;
import com.keemono.common.converter.dto.layout.LayoutDto;

/**
 * Created by edu on 25/04/2015.
 */
public class PageResponse extends AbstractResponse {

    private LayoutDto layout;
    private String name;
    private String url;

    public LayoutDto getLayout() {
        return layout;
    }

    public void setLayout(LayoutDto layout) {
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
