package com.keemono.controller.content.mapper;


import com.keemono.common.converter.request.content.ContentCreateRequest;
import com.keemono.common.mapper.CustomBaseMapper;
import com.keemono.core.mysql.domain.content.Content;
import org.springframework.stereotype.Component;

/**
 * Created by edu on 21/05/2016.
 */
@Component
public class ContentCreateRequestToContentMapper extends CustomBaseMapper<ContentCreateRequest, Content> {

    public ContentCreateRequestToContentMapper(){
        super();
        //addField("creator", "creator.uuid");
    }
}
