package com.keemono.common.converter.request.layout;

import com.keemono.common.converter.base.AbstractRequest;

/**
 * Created by edu on 10/05/2015.
 */
public class LayoutRequest extends AbstractRequest {

    private String schema;

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }
}
