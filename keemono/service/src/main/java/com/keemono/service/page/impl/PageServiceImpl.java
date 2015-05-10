package com.keemono.service.page.impl;

import com.keemono.common.converter.dto.page.PageDto;
import com.keemono.common.converter.dto.page.PageDtoConverter;
import com.keemono.core.mongo.domain.page.Page;
import com.keemono.core.mongo.repository.page.IPageRepository;
import com.keemono.service.page.IPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * Created by edu on 09/05/2015.
 */
@Service
public class PageServiceImpl implements IPageService {

    @Autowired
    private IPageRepository pageRepository;

    @Autowired
    private PageDtoConverter pageDtoConverter;

    @Override
    public PageDto getPageById(String id){
        final Page page = pageRepository.findById(id);
        return pageDtoConverter.createDto(page);
    }

    @Override
    public PageDto createPage(PageDto pageDto){
        Page page = pageDtoConverter.createFromDto(pageDto);
        page = pageRepository.save(page);
        return pageDtoConverter.createDto(page);
    }

}
