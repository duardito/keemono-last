package com.keemono.common.converter.response.user;

import com.keemono.common.converter.base.AbstractResponse;
import com.wordnik.swagger.annotations.ApiModel;

/**
 * Created by edu on 21/05/2016.
 */
@ApiModel(value = "response" , description = "user response")
public class UserResponse  extends AbstractResponse {

    private String name;
    private String lastName;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
