package com.keemono.common.converter.request.layout;

import com.keemono.common.converter.base.AbstractRequestConverter;
import com.keemono.common.converter.dto.layout.LayoutDto;
import ma.glasnost.orika.metadata.ClassMapBuilder;
import org.springframework.stereotype.Component;

/**
 * Created by edu on 10/05/2015.
 */
@Component
public class LayoutRequestConverter extends AbstractRequestConverter<LayoutRequest, LayoutDto> {

    public LayoutRequestConverter() {
        ClassMapBuilder<LayoutRequest, LayoutDto> classMap = getMapperFactory().classMap(LayoutRequest.class, LayoutDto.class);
        getMapperFactory().registerClassMap(classMap.byDefault());
    }
}
