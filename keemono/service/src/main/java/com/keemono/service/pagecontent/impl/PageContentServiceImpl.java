package com.keemono.service.pagecontent.impl;

import com.keemono.common.mapper.BaseMapper;
import com.keemono.core.mysql.Repository.pagecontent.IPageContentRepository;
import com.keemono.core.mysql.domain.pagecontent.PageContent;
import com.keemono.service.pagecontent.IPageContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by edu on 16/6/16.
 */
@Service
public class PageContentServiceImpl extends BaseMapper implements IPageContentService{

    @Autowired
    private IPageContentRepository pageContentRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public PageContent save(PageContent pageContent){
        return pageContentRepository.save(pageContent);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public PageContent update(PageContent pageContent){
        return pageContentRepository.update(pageContent);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class,readOnly = true)
    public List<PageContent> getContentByPage(String uuid){
        return pageContentRepository.getPageContentByPage(uuid);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class,readOnly = true)
    public PageContent getPageContentById(Long id){
        return pageContentRepository.findOne(id);
    }
}
