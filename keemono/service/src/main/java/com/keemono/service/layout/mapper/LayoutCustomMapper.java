package com.keemono.service.layout.mapper;

import com.keemono.common.converter.dto.layout.LayoutDto;
import com.keemono.common.mapper.CustomBaseMapper;
import com.keemono.core.mysql.domain.layout.Layout;
import org.springframework.stereotype.Component;

/**
 * Created by edu on 12/10/2015.
 */
@Component
public class LayoutCustomMapper extends CustomBaseMapper<LayoutDto, Layout> {

    public LayoutCustomMapper() {
        super();
        addField("userUuid","creator.uuid");
    }
}