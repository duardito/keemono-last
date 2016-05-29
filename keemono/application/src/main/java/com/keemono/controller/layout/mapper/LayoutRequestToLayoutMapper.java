package com.keemono.controller.layout.mapper;

import com.keemono.common.converter.request.layout.LayoutRequest;
import com.keemono.common.mapper.CustomBaseMapper;
import com.keemono.core.mysql.domain.layout.Layout;
import org.springframework.stereotype.Component;

/**
 * Created by edu on 11/10/2015.
 */
@Component
public class LayoutRequestToLayoutMapper extends CustomBaseMapper<LayoutRequest, Layout> {

    public LayoutRequestToLayoutMapper(){
        super();
        addField("schema", "schema");
        addField("name", "name");
    }

}
