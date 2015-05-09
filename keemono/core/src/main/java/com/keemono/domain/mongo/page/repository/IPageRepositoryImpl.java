package com.keemono.domain.mongo.page.repository;

import com.keemono.domain.mongo.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

/**
 * Created by edu on 09/05/2015.
 */
public class IPageRepositoryImpl implements IPageRepositoryCustom{

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Page findById(String id) {
        final Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        return mongoTemplate.findOne(query,Page.class);
    }

}
