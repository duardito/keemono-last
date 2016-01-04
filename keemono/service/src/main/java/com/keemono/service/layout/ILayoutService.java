package com.keemono.service.layout;


import com.keemono.core.mysql.domain.layout.Layout;

import java.util.List;

/**
 * Created by edu on 10/05/2015.
 */
public interface ILayoutService {

    Layout updateLayout(Layout layoutDto, String layoutUuid);

    Layout createLayout(Layout layoutDto) throws Exception;

    Layout getLayoutByUUId(String uuid);

    List<Layout> getAllLayoutList();
}
