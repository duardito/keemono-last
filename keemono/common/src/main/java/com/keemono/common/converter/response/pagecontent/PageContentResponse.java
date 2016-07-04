package com.keemono.common.converter.response.pagecontent;

import com.keemono.common.converter.response.Content.ContentResponse;
import com.keemono.common.converter.response.page.PageResponse;
import com.keemono.common.converter.response.user.UserResponse;

import java.util.List;

/**
 * Created by edu on 16/6/16.
 */
public class PageContentResponse {

    private String name;
    private String url;
    private UserResponse creator;
    private PageResponse pageResponse;
    private List<ContentResponse> content;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public UserResponse getCreator() {
        return creator;
    }

    public void setCreator(UserResponse creator) {
        this.creator = creator;
    }

    public PageResponse getPageResponse() {
        return pageResponse;
    }

    public void setPageResponse(PageResponse pageResponse) {
        this.pageResponse = pageResponse;
    }

    public List<ContentResponse> getContent() {
        return content;
    }

    public void setContent(List<ContentResponse> content) {
        this.content = content;
    }
}
