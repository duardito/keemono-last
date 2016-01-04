package com.keemono.core.mysql.Repository.page;

import com.keemono.core.mysql.Repository.BaseRepository;
import com.keemono.core.mysql.domain.page.Page;
import com.keemono.core.mysql.domain.page.Page_;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * Created by edu on 01/01/2016.
 */
@Repository
public class PageRepositoryImpl extends BaseRepository implements IPageRepository{

    @Override
    public List<Page> findAll(){
        Criteria criteria = getSession().createCriteria(Page.class);
		criteria.setFetchMode(Page_.layout.getName(), FetchMode.JOIN);
        return criteria.list();
    }

    @Override
    public Page update(Page page){
        getSession().update(page);
        getSession().flush();
        return page;
    }

    @Override
    public Page save(Page page){
        page.setUuid(UUID.randomUUID().toString());
        getSession().save(page);
        getSession().flush();
        return page;
    }

    @Override
    public Page findUUID(String uuid) {
        Criteria criteria = getSession().createCriteria(Page.class);
        criteria.setFetchMode(Page_.layout.getName(), FetchMode.JOIN);
        criteria.add(Restrictions.eq(Page_.uuid.getName() ,uuid));
        Page page = (Page) criteria.uniqueResult();
        return page;
    }
}
