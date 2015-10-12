package com.keemono.common.converter.request.layout;

import com.keemono.common.converter.base.AbstractRequest;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "layout request" , description = "layout values coming from request")
public class LayoutRequest extends AbstractRequest {

    @ApiModelProperty(value = "schema layout", required = true)
    private String schema;

    public String getSchema() {

        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }
}
