package com.keemono.controller.layout.mapper;

import com.keemono.common.converter.request.layout.LayoutCreateRequest;
import com.keemono.common.mapper.CustomBaseMapper;
import com.keemono.core.mysql.domain.layout.Layout;
import org.springframework.stereotype.Component;

/**
 * Created by edu on 11/10/2015.
 */
@Component
public class LayoutCreateRequestToLayoutMapper extends CustomBaseMapper<LayoutCreateRequest, Layout> {

    public LayoutCreateRequestToLayoutMapper(){
        super();

        addField("schema", "schema");
        addField("name", "name");
    }

}
