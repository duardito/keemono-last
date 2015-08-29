package com.keemono.common.converter.response.layout;

import com.keemono.common.converter.base.AbstractResponse;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * Created by edu on 10/05/2015.
 */
public class LayoutResponse extends AbstractResponse {

    @ApiModelProperty(value = "schema layout", required = true)
    private String schema;

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }
}
