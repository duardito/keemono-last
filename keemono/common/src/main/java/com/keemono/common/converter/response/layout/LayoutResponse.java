package com.keemono.common.converter.response.layout;

import com.keemono.common.converter.base.AbstractResponse;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * Created by edu on 10/05/2015.
 */
@ApiModel(value = "response" , description = "layout response")
public class LayoutResponse extends AbstractResponse {

    @ApiModelProperty(value = "layout name", required = true)
    private String name;

    @ApiModelProperty(value = "layout html data", required = true)
    private String schema;

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
