package com.keemono.security.json;

import java.io.Serializable;

/**
 * Created by edu on 22/05/2016.
 */
public class AuthenticationResponse implements Serializable {

    private String token;

    public AuthenticationResponse() {
        super();
    }

    public AuthenticationResponse(String token) {
        this.setToken(token);
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
