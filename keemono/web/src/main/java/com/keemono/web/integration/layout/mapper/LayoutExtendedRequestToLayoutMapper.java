package com.keemono.web.integration.layout.mapper;

import com.keemono.common.converter.request.layout.LayoutExtendedRequest;
import com.keemono.common.mapper.CustomBaseMapper;
import com.keemono.core.mysql.domain.layout.Layout;
import org.springframework.stereotype.Component;

/**
 * Created by edu on 11/10/2015.
 */
@Component
public class LayoutExtendedRequestToLayoutMapper extends CustomBaseMapper<LayoutExtendedRequest, Layout> {


    public LayoutExtendedRequestToLayoutMapper(){
        super();
        addField("creator", "creator.uuid");
    }

}
