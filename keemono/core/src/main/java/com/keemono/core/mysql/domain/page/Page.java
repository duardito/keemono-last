package com.keemono.core.mysql.domain.page;

import com.keemono.core.mysql.domain.AbstractDomain;
import com.keemono.core.mysql.domain.layout.Layout;
import com.keemono.core.mysql.domain.user.User;

import javax.persistence.*;

/**
 * Created by edu on 01/01/2016.
 */
@Entity
@Table(name = "page")
public class Page extends AbstractDomain {

    public Page(){
        super();
    }

    @JoinColumn(name = "layout_id",referencedColumnName = "id")
    @OneToOne(fetch = FetchType.LAZY)
    private Layout layout;

    @JoinColumn(name = "user_id",referencedColumnName = "id")
    @OneToOne(fetch = FetchType.LAZY)
    private User creator;

    public Layout getLayout() {
        return layout;
    }

    public void setLayout(Layout layout) {
        this.layout = layout;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }
}
