package com.keemono.core.mysql.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by edu on 31/05/2015.
 */
@MappedSuperclass
public abstract class AbstractDomain implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",nullable = false,length = 255)
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
