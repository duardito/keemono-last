package com.keemono.core.mysql.Repository.layout;

import com.keemono.core.mysql.Repository.BaseRepository;
import com.keemono.core.mysql.domain.layout.Layout;
import com.keemono.core.mysql.domain.layout.Layout_;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * Created by edu on 31/10/2015.
 */
@Repository
public class LayoutRepositoryImpl extends BaseRepository implements ILayoutRepository {

    @Override
    public List<Layout> findAll(){
        Criteria criteria = getSession().createCriteria(Layout.class);
        return criteria.list();
    }

    @Override
    public Layout update(Layout layout){
        getSession().update(layout);
        getSession().flush();
        return layout;
    }

    @Override
    public Layout save(Layout layout){
        layout.setUuid(UUID.randomUUID().toString());
        getSession().save(layout);
        getSession().flush();
        return layout;
    }

    @Override
    public Layout findUUID(String uuid) {
        Criteria criteria = getSession().createCriteria(Layout.class);
        criteria.add(Restrictions.eq(Layout_.uuid.getName() ,uuid));
        Layout layout = (Layout) criteria.uniqueResult();
        return layout;
    }

}
