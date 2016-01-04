package com.keemono.web.integration.layout.mapper;

import com.keemono.common.converter.response.layout.LayoutResponse;
import com.keemono.common.mapper.CustomBaseMapper;
import com.keemono.core.mysql.domain.layout.Layout;
import org.springframework.stereotype.Component;

/**
 * Created by edu on 25/10/2015.
 */
@Component
public class LayoutDtoToLayoutResponseMapper extends CustomBaseMapper<Layout, LayoutResponse> {
}
