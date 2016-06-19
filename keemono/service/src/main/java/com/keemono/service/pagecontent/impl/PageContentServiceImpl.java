package com.keemono.service.pagecontent.impl;

import com.keemono.common.mapper.BaseMapper;
import com.keemono.core.mysql.Repository.content.IContentRepository;
import com.keemono.core.mysql.Repository.layout.ILayoutRepository;
import com.keemono.core.mysql.Repository.page.IPageRepository;
import com.keemono.core.mysql.Repository.pagecontent.IPageContentRepository;
import com.keemono.core.mysql.domain.content.Content;
import com.keemono.core.mysql.domain.layout.Layout;
import com.keemono.core.mysql.domain.page.Page;
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

    @Autowired
    private IPageRepository pageRepository;

    @Autowired
    private ILayoutRepository layoutRepository;

    @Autowired
    private IContentRepository contentRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public PageContent save(PageContent pageContent){

        Page page = pageRepository.findUUID(pageContent.getPage().getUuid());
        Layout layout =layoutRepository.findUUID(pageContent.getLayout().getUuid());
        Content content = contentRepository.findUUID(pageContent.getContent().getUuid());
        pageContent.setLayout(layout);
        pageContent.setPage(page);
        pageContent.setContent(content);
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
