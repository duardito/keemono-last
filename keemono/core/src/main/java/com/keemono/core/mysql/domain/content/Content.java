package com.keemono.core.mysql.domain.content;

import com.keemono.core.mysql.domain.AbstractDomain;
import com.keemono.core.mysql.domain.user.User;

import javax.persistence.*;

/**
 * Created by edu on 20/05/2016.
 */
@Entity
@Table(name = "zcontent")
public class Content  extends AbstractDomain {

    public Content() {
        super(Content.class.getName());
    }

    @Column(name = "content", nullable = false,length = 2000)
    private String content;

    @JoinColumn(name = "user_id",referencedColumnName = "id")
    @OneToOne(fetch = FetchType.LAZY)
    private User creator;

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
