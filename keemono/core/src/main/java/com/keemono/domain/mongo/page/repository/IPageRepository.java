package com.keemono.domain.mongo.page.repository;

import com.keemono.domain.mongo.base.MongoRepositoryAbstract;
import com.keemono.domain.mongo.page.Page;

/**
 * Created by edu on 25/4/15.
 */
public interface IPageRepository extends MongoRepositoryAbstract<Page,String> , IPageRepositoryCustom<Page, String>{

    public Page findById(String id);
}
