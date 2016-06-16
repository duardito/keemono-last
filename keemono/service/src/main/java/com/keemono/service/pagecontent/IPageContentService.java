package com.keemono.service.pagecontent;

import com.keemono.core.mysql.domain.pagecontent.PageContent;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by edu on 16/6/16.
 */
public interface IPageContentService {
    PageContent save(PageContent pageContent);

    PageContent update(PageContent pageContent);

    List<PageContent> getContentByPage(String uuid);

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class,readOnly = true)
    PageContent getPageContentById(Long id);
}
