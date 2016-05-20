package com.keemono.core.mysql.domain.division;

import com.keemono.core.mysql.domain.AbstractDomain;
import com.keemono.core.mysql.domain.content.Content;
import com.keemono.core.mysql.domain.layout.Layout;

import javax.persistence.*;

/**
 * Created by edu on 20/05/2016.
 */
@Entity
@Table(name = "division")
public class Division extends AbstractDomain {

    public Division(){
        super(Division.class.getName());
    }

    @JoinColumn(name = "content_id",referencedColumnName = "id")
    @OneToOne(fetch = FetchType.LAZY)
    private Content content;

    @ManyToOne
    private Layout layout;

    public Layout getLayout() {
        return layout;
    }

    public void setLayout(Layout layout) {
        this.layout = layout;
    }

    @Column(name = "data", nullable = false,length = 2000)
    private String schema;

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }
}
