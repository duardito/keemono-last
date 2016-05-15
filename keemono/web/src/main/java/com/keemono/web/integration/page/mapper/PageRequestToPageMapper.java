package com.keemono.web.integration.page.mapper;

import com.keemono.common.converter.request.page.PageRequest;
import com.keemono.common.mapper.CustomBaseMapper;
import com.keemono.core.mysql.domain.page.Page;
import org.springframework.stereotype.Component;

/**
 * Created by edu on 01/01/2016.
 */
@Component
public class PageRequestToPageMapper extends CustomBaseMapper<PageRequest, Page> {

    public PageRequestToPageMapper(){
        super();
        addField("layout", "layout.uuid");
        addField("creator", "creator.uuid");
    }
}
