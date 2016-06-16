package com.keemono.core.mysql.domain.pagecontent;

import com.keemono.core.mysql.domain.layout.Layout;
import com.keemono.core.mysql.domain.page.Page;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by edu on 15/06/2016.
 */
@Entity
@Table(name = "page_content")
public class PageContent implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "page_id",referencedColumnName = "id")
    @OneToOne(fetch = FetchType.LAZY)
    private Page page;

    @JoinColumn(name = "layout_id",referencedColumnName = "id")
    @OneToOne(fetch = FetchType.LAZY)
    private Layout layout;

    @Column(name = "content_div", nullable = false,length = 2000)
    private String contentDiv;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public Layout getLayout() {
        return layout;
    }

    public void setLayout(Layout layout) {
        this.layout = layout;
    }

    public String getContentDiv() {
        return contentDiv;
    }

    public void setContentDiv(String contentDiv) {
        this.contentDiv = contentDiv;
    }

}
