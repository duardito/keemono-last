package com.keemono.common.converter.dto.layout;

import com.keemono.common.converter.base.AbstractDto;

import java.util.UUID;

/**
 * Created by edu on 10/05/2015.
 */
public class LayoutDto extends AbstractDto {

    private String uuid;

    private String schema;

    private String userId;

    public String getUuid() {
        return UUID.randomUUID().toString();
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }
}
