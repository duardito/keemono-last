package com.keemono.common.converter.dto.layout;


import com.keemono.common.converter.base.AbstractDtoConverter;
import com.keemono.core.solr.domain.layout.Layout;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.metadata.ClassMapBuilder;
import org.springframework.stereotype.Component;

/**
 * Created by edu on 10/05/2015.
 */
@Component
public class LayoutDtoConverter extends AbstractDtoConverter<LayoutDto, Layout> {

    public LayoutDtoConverter(){
        ClassMapBuilder<LayoutDto, Layout> classMap = getMapperFactory().classMap(LayoutDto.class, Layout.class);
        classMap.byDefault().customize(new CustomMapper<LayoutDto, Layout>() {
            @Override
            public void mapAtoB(LayoutDto folderReq, Layout doc, MappingContext context) {

            }
        });

        getMapperFactory().registerClassMap(classMap.byDefault());
    }
}
