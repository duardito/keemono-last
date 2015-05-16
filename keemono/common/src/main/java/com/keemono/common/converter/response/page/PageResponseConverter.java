package com.keemono.common.converter.response.page;

import com.keemono.common.converter.dto.page.PageDto;
import com.keemono.common.converter.base.AbstractResponseConverter;
import ma.glasnost.orika.metadata.ClassMapBuilder;
import org.springframework.stereotype.Component;

/**
 * Created by edu on 09/05/2015.
 */
@Component
public class PageResponseConverter extends AbstractResponseConverter<PageResponse, PageDto> {

    public PageResponseConverter() {
        ClassMapBuilder<PageResponse, PageDto> classMap = getMapperFactory().classMap(PageResponse.class, PageDto.class);
        getMapperFactory().registerClassMap(classMap.byDefault());
    }
}