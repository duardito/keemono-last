package com.keemono.core.mongo.converters;

import com.keemono.core.mongo.domain.layout.Layout;
import com.keemono.core.mongo.domain.page.Page;
import com.mongodb.DBObject;
import org.springframework.core.convert.converter.Converter;

/**
 * Created by edu on 09/05/2015.
 */
public class PageReadConverter implements Converter<DBObject, Page> {
    @Override
    public Page convert(DBObject source) {
        Page page = new Page();
        page.setId((String) source.get("_id"));
        page.setLayout((Layout) source.get("layout"));
        page.setName((String) source.get("name"));
        page.setUrl((String)source.get("url"));
        return page;
    }
}
