package com.keemono.domain.mongo.page.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * Created by edu on 09/05/2015.
 */
public class PageRepositoryImpl implements IPageRepositoryCustom{

    @Autowired
    private MongoTemplate mongoTemplate;

}
