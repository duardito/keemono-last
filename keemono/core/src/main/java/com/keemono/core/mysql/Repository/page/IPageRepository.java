package com.keemono.core.mysql.Repository.page;

import com.keemono.core.mysql.domain.page.Page;

import java.io.Serializable;
import java.util.List;

/**
 * Created by edu on 01/01/2016.
 */
public interface IPageRepository<M, S extends Serializable> {

    Page update(Page layout);

    Page findUUID(String uuid);

    Page save(Page layout);

    List<Page> findAll();
}
