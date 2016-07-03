package com.keemono.core.mysql.Repository.pagecontent;

import com.keemono.core.mysql.domain.page.Page;
import com.keemono.core.mysql.domain.pagecontent.PageContent;

import java.util.List;

/**
 * Created by edu on 15/06/2016.
 */
public interface IPageContentRepository {

    PageContent save(PageContent pageContent);

    PageContent update(PageContent pageContent);

    PageContent findOne(Long id);


    List<PageContent> getPageContentByPage(Page page);
}
