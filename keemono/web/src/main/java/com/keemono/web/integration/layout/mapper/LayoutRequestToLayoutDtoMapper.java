package com.keemono.web.integration.layout.mapper;

import com.keemono.common.converter.dto.layout.LayoutDto;
import com.keemono.common.converter.request.layout.LayoutRequest;
import com.keemono.common.mapper.CustomBaseMapper;
import org.springframework.stereotype.Component;

/**
 * Created by edu on 11/10/2015.
 */
@Component
public class LayoutRequestToLayoutDtoMapper extends CustomBaseMapper<LayoutRequest, LayoutDto> {

    public LayoutRequestToLayoutDtoMapper(){
        super();
        addField("values", "values");
        addField("name", "name");
    }

}
