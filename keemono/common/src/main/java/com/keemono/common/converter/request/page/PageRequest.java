package com.keemono.common.converter.request.page;

import com.keemono.common.converter.base.AbstractRequest;

/**
 * Created by edu on 09/05/2015.
 */
public class PageRequest extends AbstractRequest {

    private String layout;

    private String name;

    private String creator;

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public String getName() {
        return name;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public void setName(String name) {
        this.name = name;
    }
}
