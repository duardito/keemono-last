package com.keemono.core.mysql.domain.layout;

import com.keemono.core.mysql.domain.AbstractDomain;
import com.keemono.core.mysql.domain.division.Division;
import com.keemono.core.mysql.domain.user.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by edu on 12/10/2015.
 */
@Entity
@Table(name = "layout")
public class Layout extends AbstractDomain {

    public Layout(){
        super(Layout.class.getName());
    }

    @OneToMany(mappedBy = "layout", fetch = FetchType.LAZY)
    private List<Division> divisionList = new ArrayList<Division>();

    @Column(name = "data", nullable = false,length = 2000)
    private String schema;

    @JoinColumn(name = "user_id",referencedColumnName = "id")
    @OneToOne(fetch = FetchType.LAZY)
    private User creator;

    public List<Division> getDivisionList() {
        return divisionList;
    }

    public void setDivisionList(List<Division> divisionList) {
        this.divisionList = divisionList;
    }

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

}
