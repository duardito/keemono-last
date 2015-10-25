package com.keemono.common.converter.response.layout;

import com.keemono.common.converter.base.AbstractResponse;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * Created by edu on 10/05/2015.
 */
@ApiModel(value = "response" , description = "layout response")
public class LayoutResponse extends AbstractResponse {

    @ApiModelProperty(value = "schema layout", required = true)
    private String name;

    private String values;

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
