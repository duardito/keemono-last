package com.keemono.controller.pagecontent.mapper;

import com.keemono.common.converter.request.pagecontent.PageContentRequest;
import com.keemono.common.mapper.CustomBaseMapper;
import com.keemono.core.mysql.domain.pagecontent.PageContent;
import org.springframework.stereotype.Component;

/**
 * Created by edu on 16/06/2016.
 */
@Component
public class PageContentRequestToPageContentMapper extends CustomBaseMapper<PageContentRequest, PageContent> {

    public PageContentRequestToPageContentMapper(){
        super();
        addField("pageUuid","page.uuid");
        addField("layoutUuid","layout.uuid");
        addField("contentDiv","contentDiv");
        addField("contentUuid","content.uuid");
    }
}
