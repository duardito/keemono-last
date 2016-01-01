package com.keemono.core.mysql.domain.layout;

import com.keemono.core.mysql.domain.AbstractDomain;
import com.keemono.core.mysql.domain.user.User;

import javax.persistence.*;

/**
 * Created by edu on 12/10/2015.
 */
@Entity
@Table(name = "layout")
public class Layout extends AbstractDomain {

    public Layout(){
        super();

    }

    @JoinColumn(name = "user_id",referencedColumnName = "id")
    @OneToOne(fetch = FetchType.LAZY)
    private User creator;

    @Column(name = "data", nullable = false,length = 2000)
    private String schema;

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }


    @Override
    public String toString() {
        return "Layout{" +
                "creator=" + creator +
                ", schema='" + schema + '\'' +
                '}';
    }
}
