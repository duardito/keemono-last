package com.keemono.common.converter.response.Content;

import com.keemono.common.converter.base.AbstractResponse;
import com.keemono.common.converter.response.user.UserResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * Created by edu on 21/05/2016.
 */
@ApiModel(value = "response" , description = "content response")
public class ContentResponse extends AbstractResponse {

    private String name;
    private String content;

    @ApiModelProperty(value = "creator", required = true)
    private UserResponse creator;

    public UserResponse getCreator() {
        return creator;
    }

    public void setCreator(UserResponse creator) {
        this.creator = creator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
