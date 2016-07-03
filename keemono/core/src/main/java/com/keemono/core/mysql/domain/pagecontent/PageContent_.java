package com.keemono.core.mysql.domain.pagecontent;

import com.keemono.core.mysql.domain.content.Content;
import com.keemono.core.mysql.domain.layout.Layout;
import com.keemono.core.mysql.domain.page.Page;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * Created by edu on 15/06/2016.
 */
@StaticMetamodel(PageContent.class)
public abstract class PageContent_  {

    public static volatile SingularAttribute<PageContent, Long> id;
    public static volatile SingularAttribute<PageContent, Page> page;
    public static volatile SingularAttribute<PageContent, Layout> layout;
    public static volatile SingularAttribute<PageContent, Content> content;
    public static volatile SingularAttribute<PageContent, String> contentDiv;

}
