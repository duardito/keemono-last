package com.keemono.common.converter.base;

import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * Created by edu on 25/04/2015.
 */
public abstract class AbstractResponse {

    @ApiModelProperty(value = "uuid", required = true)
    private String uuid;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
