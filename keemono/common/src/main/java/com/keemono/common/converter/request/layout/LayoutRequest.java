package com.keemono.common.converter.request.layout;

import com.keemono.common.converter.base.AbstractRequest;
import com.wordnik.swagger.annotations.ApiModel;

@ApiModel(value = "layout request" , description = "layout values coming from request")
public class LayoutRequest extends AbstractRequest {

    private String name;
    private String schema;
    private Long userId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
