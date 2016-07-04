package com.keemono.controller.pagecontent.mapper;

import com.keemono.common.converter.response.Content.ContentResponse;
import com.keemono.common.converter.response.page.PageResponse;
import com.keemono.common.converter.response.pagecontent.ExtendedPageContentResponse;
import com.keemono.common.converter.response.pagecontent.PageContentResponse;
import com.keemono.common.mapper.CustomBaseMapper;
import com.keemono.core.mysql.domain.content.Content;
import com.keemono.core.mysql.domain.page.Page;
import com.keemono.core.mysql.domain.pagecontent.PageContent;
import ma.glasnost.orika.MappingContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by edu on 16/06/2016.
 */
@Component
public class ExtendedPageContentResponseToPageContentResponseMapper extends CustomBaseMapper<ExtendedPageContentResponse, PageContentResponse> {

    public ExtendedPageContentResponseToPageContentResponseMapper() {
        super();
    }

    @Override
    public void mapAtoB(ExtendedPageContentResponse extendedPageContentResponse, PageContentResponse pageContentResponse, MappingContext context) {
        final List<ContentResponse> contentList= new ArrayList<>(0);
        for (PageContent pageContent : extendedPageContentResponse.getResponse()) {
            Content content = pageContent.getContent();
            String divId = pageContent.getContentDiv();
            Page page = pageContent.getPage();
            PageResponse pageResponse= new PageResponse();
            pageResponse.setUuid(page.getUuid());
            pageResponse.setName(page.getName());
            pageContentResponse.setPageResponse(pageResponse);

            ContentResponse contentResponse = new ContentResponse();
            contentResponse.setUuid(content.getUuid());
            contentResponse.setContent(content.getContent());
            contentResponse.setDivId(divId);
            contentList.add(contentResponse);
        }

        pageContentResponse.setContent(contentList);
    }
}
