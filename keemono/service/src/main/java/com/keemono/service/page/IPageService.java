package com.keemono.service.page;

import com.keemono.common.dto.converter.page.PageDto;

/**
 * Created by edu on 09/05/2015.
 */
public interface IPageService {

    PageDto getPageById(String id);
}
