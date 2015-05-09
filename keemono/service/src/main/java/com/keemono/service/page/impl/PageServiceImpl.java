package com.keemono.service.page.impl;

import com.keemono.domain.mongo.page.Page;
import com.keemono.domain.mongo.page.repository.IPageRepository;
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

    @Override
    public Page getPageById(String id){

        return pageRepository.findById(id);
    }

}
