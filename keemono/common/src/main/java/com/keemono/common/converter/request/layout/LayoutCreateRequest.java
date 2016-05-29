package com.keemono.common.converter.request.layout;


import io.swagger.annotations.ApiModel;

/**
 * Created by edu on 08/03/2016.
 */
@ApiModel(value = "create layout request" , description = "layout values coming from create request")
public class LayoutCreateRequest {

    private String name;
    private String schema;
    private String creator;

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

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
}
