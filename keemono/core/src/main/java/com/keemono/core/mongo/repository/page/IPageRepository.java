package com.keemono.core.mongo.repository.page;

import com.keemono.core.mongo.base.MongoRepositoryAbstract;
import com.keemono.core.mongo.domain.page.Page;

/**
 * Created by edu on 25/4/15.
 */
public interface IPageRepository extends MongoRepositoryAbstract<Page,String> , IPageRepositoryCustom<Page, String>{


}
