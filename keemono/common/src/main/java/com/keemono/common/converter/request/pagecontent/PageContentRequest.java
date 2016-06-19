package com.keemono.common.converter.request.pagecontent;

import java.io.Serializable;

/**
 * Created by edu on 16/6/16.
 */
public class PageContentRequest implements Serializable{

    private String pageUuid;
    private String layoutUuid;
    private String contentUuid;
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
