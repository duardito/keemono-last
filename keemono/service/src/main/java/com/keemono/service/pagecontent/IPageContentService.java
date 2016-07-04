package com.keemono.service.pagecontent;

import com.keemono.common.converter.response.pagecontent.PageContentResponse;
import com.keemono.core.mysql.domain.pagecontent.PageContent;

/**
 * Created by edu on 16/6/16.
 */
public interface IPageContentService {

    PageContent save(PageContent pageContent);

    PageContent update(PageContent pageContent);

    PageContentResponse getContentByPage(String uuid);

    PageContent getPageContentById(Long id);
}
