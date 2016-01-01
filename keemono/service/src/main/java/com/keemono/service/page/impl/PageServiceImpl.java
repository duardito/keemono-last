package com.keemono.service.page.impl;

import com.keemono.common.converter.dto.layout.LayoutDto;
import com.keemono.common.converter.dto.page.PageDto;
import com.keemono.common.mapper.BaseMapper;
import com.keemono.core.mysql.Repository.page.IPageRepository;
import com.keemono.core.mysql.domain.layout.Layout;
import com.keemono.core.mysql.domain.page.Page;
import com.keemono.service.layout.ILayoutService;
import com.keemono.service.page.IPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * Created by edu on 09/05/2015.
 */
@Service
public class PageServiceImpl extends BaseMapper implements IPageService {

    @Autowired
    private IPageRepository pageRepository;

    @Autowired
    private ILayoutService layoutService;

    @Override
    @Transactional(propagation = Propagation.REQUIRED,   rollbackFor = Exception.class,readOnly = true)
    public PageDto getPageByUUId(String uuid){
        Page page =pageRepository.findUUID(uuid);
        return mapper.map(page, PageDto.class);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,   rollbackFor = Exception.class)
    public PageDto createPage(PageDto pageDto){

        LayoutDto layoutDto=layoutService.getLayoutByUUId(pageDto.getLayout());

        Page page = mapper.map(pageDto, Page.class);
        Layout layout = mapper.map(layoutDto, Layout.class);
        page.setLayout(layout);

        page =pageRepository.save(page);
        return mapper.map(page,PageDto.class);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,   rollbackFor = Exception.class)
    public PageDto updatePage(PageDto pageDto, String uuid){

        Page page = pageRepository.findUUID(uuid);

        if(pageDto.getLayout() != null){
            LayoutDto layout = layoutService.getLayoutByUUId(pageDto.getLayout());
            Layout dto = mapper.map(layout, Layout.class);
            page.setLayout(dto);
        }
        if(pageDto.getName() !=null && !pageDto.getName().isEmpty()){
            page.setName(pageDto.getName());
        }

        pageRepository.update(page);
        return mapper.map(page,PageDto.class);
    }
}
