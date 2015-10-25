package com.keemono.core.mysql.domain.layout;

import com.keemono.core.mysql.domain.AbstractDomain;

import javax.persistence.*;

/**
 * Created by edu on 12/10/2015.
 */
@Entity
@Table(name = "layout")
public class Layout extends AbstractDomain {

    @Column(name = "valores", nullable = false,length = 2000)
    private String values;

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }
}
