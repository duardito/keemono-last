package com.keemono.controller.content.mapper;

import com.keemono.common.converter.response.Content.ContentResponse;
import com.keemono.common.mapper.CustomBaseMapper;
import com.keemono.core.mysql.domain.content.Content;
import org.springframework.stereotype.Component;

/**
 * Created by edu on 21/05/2016.
 */
@Component
public class ContentToContentResponseMapper extends CustomBaseMapper<Content, ContentResponse> {

    public ContentToContentResponseMapper(){
        super();
        addField("creator.name", "creator.name");
        addField("creator.uuid", "creator.uuid");
        addField("creator.lastName", "creator.lastName");
        addField("creator.email", "creator.email");
    }
}
