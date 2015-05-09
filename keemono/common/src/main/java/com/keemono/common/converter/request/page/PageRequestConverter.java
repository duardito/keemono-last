package com.keemono.common.converter.request.page;

import com.keemono.common.converter.base.AbstractRequestConverter;
import com.keemono.common.converter.dto.page.PageDto;
import ma.glasnost.orika.metadata.ClassMapBuilder;
import org.springframework.stereotype.Component;

/**
 * Created by edu on 09/05/2015.
 */
@Component
public class PageRequestConverter extends AbstractRequestConverter<PageRequest, PageDto> {

    public PageRequestConverter() {
        ClassMapBuilder<PageRequest, PageDto> classMap = getMapperFactory().classMap(PageRequest.class, PageDto.class);
        getMapperFactory().registerClassMap(classMap.byDefault());
    }
}
