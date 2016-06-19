package com.keemono.controller.pagecontent.mapper;

import com.keemono.common.converter.response.pagecontent.PageContentResponse;
import com.keemono.common.mapper.CustomBaseMapper;
import com.keemono.core.mysql.domain.pagecontent.PageContent;
import org.springframework.stereotype.Component;

/**
 * Created by edu on 16/06/2016.
 */
@Component
public class PageContentToPageContentResponseMapper extends CustomBaseMapper<PageContent, PageContentResponse> {

    public PageContentToPageContentResponseMapper(){
        super();
    }
}
