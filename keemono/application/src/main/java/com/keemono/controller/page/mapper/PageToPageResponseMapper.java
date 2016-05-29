package com.keemono.controller.page.mapper;

import com.keemono.common.converter.response.page.PageResponse;
import com.keemono.common.mapper.CustomBaseMapper;
import com.keemono.core.mysql.domain.page.Page;
import org.springframework.stereotype.Component;

/**
 * Created by edu on 24/04/2016.
 */
@Component
public class PageToPageResponseMapper extends CustomBaseMapper<Page, PageResponse> {
    public PageToPageResponseMapper(){
        super();
        addField("layout.uuid", "layout.uuid");
        addField("layout.name", "layout.name");
        addField("layout.schema", "layout.schema");
        addField("layout.creator.uuid", "layout.creator");

        addField("creator.name", "creator.name");
        addField("creator.uuid", "creator.uuid");
        addField("creator.lastName", "creator.lastName");
        addField("creator.email", "creator.email");

    }
}
