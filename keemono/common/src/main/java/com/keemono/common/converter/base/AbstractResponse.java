package com.keemono.common.converter.base;

import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * Created by edu on 25/04/2015.
 */
public abstract class AbstractResponse {

    @ApiModelProperty(value = "uuid", required = true)
    private String uuid;

    @ApiModelProperty(value = "creator", required = true)
    private String creator;

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
