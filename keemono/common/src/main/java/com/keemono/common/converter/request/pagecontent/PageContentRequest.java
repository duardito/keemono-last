package com.keemono.common.converter.request.pagecontent;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by edu on 16/6/16.
 */
@ApiModel(value = "create associations per page" , description = "values to associate a content in a div per page")
public class PageContentRequest implements Serializable{

    @ApiModelProperty(value = "uuid from page", required = true)
    private String pageUuid;

    @ApiModelProperty(value = "uuid from layout", required = true)
    private String layoutUuid;

    @ApiModelProperty(value = "uuid from content", required = true)
    private String contentUuid;

    @ApiModelProperty(value = "id from div that contains a content", required = true)
    private String contentDiv;

    public String getContentUuid() {
        return contentUuid;
    }

    public void setContentUuid(String contentUuid) {
        this.contentUuid = contentUuid;
    }

    public String getPageUuid() {
        return pageUuid;
    }

    public void setPageUuid(String pageUuid) {
        this.pageUuid = pageUuid;
    }

    public String getLayoutUuid() {
        return layoutUuid;
    }

    public void setLayoutUuid(String layoutUuid) {
        this.layoutUuid = layoutUuid;
    }

    public String getContentDiv() {
        return contentDiv;
    }

    public void setContentDiv(String contentDiv) {
        this.contentDiv = contentDiv;
    }
}
