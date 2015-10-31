package com.keemono.core.mysql.Repository.layout;

import com.keemono.core.mysql.domain.layout.Layout;

import java.io.Serializable;

/**
 * Created by edu on 31/10/2015.
 */
public interface LayoutRepositoryCustom <M, S extends Serializable>{

    Layout update(Layout layout);

    Layout findByUUID(String uuid);
}
