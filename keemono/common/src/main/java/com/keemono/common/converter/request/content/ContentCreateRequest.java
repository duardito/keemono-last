package com.keemono.common.converter.request.content;


import io.swagger.annotations.ApiModel;

/**
 * Created by edu on 21/05/2016.
 */
@ApiModel(value = "create content request" , description = "content values coming from create request")
public class ContentCreateRequest {

//    private String creator;
    private String content;
    private String name;

//    public String getCreator() {
//        return creator;
//    }
//
//    public void setCreator(String creator) {
//        this.creator = creator;
//    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
