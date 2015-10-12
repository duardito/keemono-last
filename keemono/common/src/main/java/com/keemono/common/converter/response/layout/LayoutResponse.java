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
    private String pepe;

    public String getPepe() {
        return pepe;
    }

    public void setPepe(String pepe) {
        this.pepe = pepe;
    }
}
