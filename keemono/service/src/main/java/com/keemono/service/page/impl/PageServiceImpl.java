package com.keemono.service.page.impl;

import com.keemono.common.mapper.BaseMapper;
import com.keemono.core.mysql.Repository.page.IPageRepository;
import com.keemono.core.mysql.Repository.user.IUserRepository;
import com.keemono.core.mysql.domain.layout.Layout;
import com.keemono.core.mysql.domain.page.Page;
import com.keemono.service.layout.ILayoutService;
import com.keemono.service.page.IPageService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by edu on 09/05/2015.
 */
@Service
public class PageServiceImpl extends BaseMapper implements IPageService {

    @Autowired
    private IPageRepository pageRepository;

    @Autowired
    private ILayoutService layoutService;

    @Autowired
    private IUserRepository userRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = true)
    public List<Page> getAllPages() {
        List<Page> list = pageRepository.findAll();
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = true)
    public Page getPageByUUId(String uuid) {
        return pageRepository.findUUID(uuid);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Page createPage(Page page) {

        Layout layout = layoutService.getLayoutByUUId(page.getLayout().getUuid());

        page.setLayout(layout);
        page = pageRepository.save(page);
        return page;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Page updatePage(Page pageDto, String uuid) {

        Page page = pageRepository.findUUID(uuid);

        if (pageDto.getLayout() != null) {
            Layout layout = layoutService.getLayoutByUUId(pageDto.getLayout().getUuid());
            page.setLayout(layout);
        }
        if (pageDto.getName() != null && !pageDto.getName().isEmpty()) {
            page.setName(pageDto.getName());
        }

        page = pageRepository.update(page);
        return page;
    }
}
