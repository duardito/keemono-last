package com.keemono.common.converter.dto.layout;

import com.keemono.common.converter.base.AbstractDto;

/**
 * Created by edu on 10/05/2015.
 */
public class LayoutDto extends AbstractDto {


    private String layoutUuid;

    private String schema;

    private String userUuid;

    public String getLayoutUuid() {
         return layoutUuid;
    }

    public void setLayoutUuid(String layoutUuid) {
        this.layoutUuid = layoutUuid;
    }

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }
}
