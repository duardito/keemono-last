package com.keemono.integration;

import com.keemono.common.converter.dto.layout.LayoutDto;
import com.keemono.common.converter.response.layout.LayoutResponse;
import com.keemono.common.mapper.CustomBaseMapper;
import org.springframework.stereotype.Component;

/**
 * Created by edu on 11/10/2015.
 */
@Component
public class LayoutCustomMapper extends CustomBaseMapper<LayoutDto, LayoutResponse> {

    public LayoutCustomMapper(){
        super();
        addField("schema", "pepe");
    }

}
