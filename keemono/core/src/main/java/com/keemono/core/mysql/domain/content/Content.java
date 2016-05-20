package com.keemono.core.mysql.domain.content;

import com.keemono.core.mysql.domain.AbstractDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by edu on 20/05/2016.
 */
@Entity
@Table(name = "content")
public class Content  extends AbstractDomain {

    public Content() {
        super(Content.class.getName());
    }

    @Column(name = "content", nullable = false,length = 2000)
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
