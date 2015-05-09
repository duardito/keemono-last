package com.keemono.service.page;

import com.keemono.domain.mongo.page.Page;

/**
 * Created by edu on 09/05/2015.
 */
public interface IPageService {

    Page getPageById(String id);
}
