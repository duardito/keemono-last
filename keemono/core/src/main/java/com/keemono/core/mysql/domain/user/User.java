package com.keemono.core.mysql.domain.user;

import com.keemono.core.mysql.domain.AbstractDomain;

import javax.persistence.*;

/**
 * Created by edu on 23/05/2015.
 */

@Entity
@Table(name = "user")
public class User extends AbstractDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
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
