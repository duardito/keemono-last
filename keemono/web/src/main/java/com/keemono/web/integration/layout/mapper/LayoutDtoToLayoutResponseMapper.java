package com.keemono.web.integration.layout.mapper;

import com.keemono.common.converter.dto.layout.LayoutDto;
import com.keemono.common.converter.response.layout.LayoutResponse;
import com.keemono.common.mapper.CustomBaseMapper;
import org.springframework.stereotype.Component;

/**
 * Created by edu on 25/10/2015.
 */
@Component
public class LayoutDtoToLayoutResponseMapper extends CustomBaseMapper<LayoutDto, LayoutResponse> {
}
