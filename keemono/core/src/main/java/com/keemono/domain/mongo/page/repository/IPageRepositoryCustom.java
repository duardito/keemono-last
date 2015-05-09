package com.keemono.domain.mongo.page.repository;

import java.io.Serializable;

/**
 * Created by edu on 09/05/2015.
 */
public interface IPageRepositoryCustom <M, S extends Serializable> {

    M findById(String id);

}
