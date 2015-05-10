package com.keemono.common.converter.response.layout;

import com.keemono.common.converter.base.AbstractResponseConverter;
import com.keemono.common.converter.dto.layout.LayoutDto;
import ma.glasnost.orika.metadata.ClassMapBuilder;
import org.springframework.stereotype.Component;

/**
 * Created by edu on 10/05/2015.
 */
@Component
public class LayoutResponseConverter extends AbstractResponseConverter<LayoutResponse, LayoutDto> {

    public LayoutResponseConverter() {
        ClassMapBuilder<LayoutResponse, LayoutDto> classMap = getMapperFactory().classMap(LayoutResponse.class, LayoutDto.class);
        getMapperFactory().registerClassMap(classMap.byDefault());
    }
}
