package com.keemono.common.converter.dto.page;

import com.keemono.common.converter.base.AbstractDtoConverter;
import com.keemono.domain.mongo.page.Page;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.metadata.ClassMapBuilder;
import org.springframework.stereotype.Component;

/**
 * Created by edu on 25/4/15.
 */
@Component
public  class PageDtoConverter extends AbstractDtoConverter<PageDto, Page> {

    public PageDtoConverter(){
        ClassMapBuilder<PageDto, Page> classMap = getMapperFactory().classMap(PageDto.class, Page.class);
        classMap.byDefault().customize(new CustomMapper<PageDto, Page>() {
            @Override
            public void mapAtoB(PageDto folderReq, Page doc, MappingContext context) {

            }
        });

        getMapperFactory().registerClassMap(classMap.byDefault());
    }
}
