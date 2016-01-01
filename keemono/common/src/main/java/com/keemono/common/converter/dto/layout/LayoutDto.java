package com.keemono.common.converter.dto.layout;

import com.keemono.common.converter.base.AbstractDto;

/**
 * Created by edu on 10/05/2015.
 */
public class LayoutDto extends AbstractDto {

    private String schema;

    private String creator;



    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }
}
