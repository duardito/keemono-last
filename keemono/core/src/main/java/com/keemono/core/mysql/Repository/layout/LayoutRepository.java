package com.keemono.core.mysql.Repository.layout;

import com.keemono.core.mysql.domain.layout.Layout;

import java.io.Serializable;
import java.util.List;

/**
 * Created by edu on 31/10/2015.
 */

public interface LayoutRepository<M, S extends Serializable>{

    Layout update(Layout layout);

    Layout findUUID(String uuid);

    Layout save(Layout layout);

    List<Layout> findAll();
}
