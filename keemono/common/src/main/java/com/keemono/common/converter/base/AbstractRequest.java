package com.keemono.common.converter.base;

/**
 * Created by edu on 09/05/2015.
 */
public abstract class AbstractRequest {

    private String uuid;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
