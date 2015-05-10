package com.keemono.core.mongo.converters;

import com.keemono.core.mongo.domain.page.Page;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.springframework.core.convert.converter.Converter;

/**
 * Created by edu on 09/05/2015.
 */
public class PageWriteConverter implements Converter<Page, DBObject> {
    @Override
    public DBObject convert(Page source) {
        DBObject dbo = new BasicDBObject();
        dbo.put("_id", source.getId());
        dbo.put("layout", source.getLayout());
        dbo.put("name", source.getName());
        dbo.put("url", source.getUrl());
        return null;
    }
}
