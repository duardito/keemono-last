package com.keemono.service.page.mapper;

import com.keemono.common.converter.dto.page.PageDto;
import com.keemono.common.mapper.CustomBaseMapper;
import com.keemono.core.mysql.domain.page.Page;
import org.springframework.stereotype.Component;

/**
 * Created by edu on 01/01/2016.
 */
@Component
public class PageDtoToPageMapper extends CustomBaseMapper<PageDto, Page> {


    public  PageDtoToPageMapper(){
        super();
    }
}
