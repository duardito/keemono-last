package com.keemono.common.converter.request.layout;

import com.keemono.common.converter.base.AbstractRequest;
import com.wordnik.swagger.annotations.ApiModel;

@ApiModel(value = "layout request" , description = "layout values coming from request")
public class LayoutRequest extends AbstractRequest {

    private String name;
    private String values;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }
}
