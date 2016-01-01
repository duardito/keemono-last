package com.keemono.service.page;

import com.keemono.common.converter.dto.page.PageDto;

/**
 * Created by edu on 09/05/2015.
 */
public interface IPageService {

    PageDto getPageByUUId(String id);

    PageDto createPage(PageDto pageDto);

    PageDto updatePage(PageDto pageDto, String uuid);
}
