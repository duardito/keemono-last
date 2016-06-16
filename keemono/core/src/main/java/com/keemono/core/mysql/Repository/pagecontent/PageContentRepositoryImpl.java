package com.keemono.core.mysql.Repository.pagecontent;

import com.keemono.core.mysql.Repository.BaseRepository;
import com.keemono.core.mysql.domain.pagecontent.PageContent;
import com.keemono.core.mysql.domain.pagecontent.PageContent_;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by edu on 15/06/2016.
 */
@Repository
public class PageContentRepositoryImpl extends BaseRepository implements IPageContentRepository {

    @Override
    public PageContent save(PageContent pageContent) {
        getSession().save(pageContent);
        getSession().flush();
        return pageContent;
    }

    @Override
    public PageContent update(PageContent pageContent) {
        getSession().update(pageContent);
        getSession().flush();
        return pageContent;
    }

    @Override
    public PageContent findOne(Long id) {
        Criteria criteria = getSession().createCriteria(PageContent.class);
        criteria.add(Restrictions.eq(PageContent_.id.getName(), id));
        PageContent pageContent = (PageContent) criteria.uniqueResult();
        return pageContent;
    }

    @Override
    public List<PageContent> getPageContentByPage(String uuid) {
        Criteria criteria = getSession().createCriteria(PageContent.class);
        criteria.add(Restrictions.eq(PageContent_.page.getName(), uuid));
        return criteria.list();
    }
}
