package com.keemono.web.integration.layout.mapper;

import com.keemono.common.converter.response.layout.LayoutResponse;
import com.keemono.common.mapper.CustomBaseMapper;
import com.keemono.core.mysql.domain.layout.Layout;
import org.springframework.stereotype.Component;

/**
 * Created by edu on 25/10/2015.
 */
@Component
public class LayoutToLayoutResponseMapper extends CustomBaseMapper<Layout, LayoutResponse> {

    public LayoutToLayoutResponseMapper(){
        super();
        addField("creator.uuid","creator");
    }
}
