package com.keemono.service.content.impl;

import com.keemono.common.mapper.BaseMapper;
import com.keemono.core.mysql.Repository.content.IContentRepository;
import com.keemono.core.mysql.domain.content.Content;
import com.keemono.core.mysql.domain.user.User;
import com.keemono.service.content.IContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by edu on 21/05/2016.
 */
@Service
public class ContentServiceImpl extends BaseMapper implements IContentService {

    @Autowired
    private IContentRepository contentRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Content createContent(Content content) {

        content.setCreator(getLoggedUser());
        return contentRepository.save(content);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = true)
    public List<Content> getAllContentByOwner() {

        return contentRepository.findAllByCreator(getLoggedUser());
    }
}
