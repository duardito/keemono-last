package com.keemono.domain.mongo.page.repository;

import com.keemono.domain.mongo.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * Created by edu on 09/05/2015.
 */
public class IPageRepositoryImpl implements IPageRepositoryCustom{

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Page findById(String id) {
        Page page = new Page();
        page.setName("nameee");
        return page;
    }



}
