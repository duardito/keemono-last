package com.keemono.service.page;


import java.util.List;

import com.keemono.core.mysql.domain.page.Page;

/**
 * Created by edu on 09/05/2015.
 */
public interface IPageService {

    Page getPageByUUId(String id);

    Page createPage(Page pageDto);

    Page updatePage(Page pageDto, String uuid);

	List<Page> getAllPages();
}
