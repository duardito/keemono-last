package com.keemono.core.mongo.base;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * Created by edu on 25/4/15.
 */
public abstract class AbstractDocument implements Serializable {

    @Id
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
