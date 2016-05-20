package com.keemono.core.mysql.Repository.content;

import com.keemono.core.mysql.Repository.BaseRepository;
import com.keemono.core.mysql.domain.content.Content;
import com.keemono.core.mysql.domain.division.Division;
import com.keemono.core.mysql.domain.layout.Layout_;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Created by edu on 20/05/2016.
 */
@Repository
public class ContentRepositoryImpl extends BaseRepository implements IContentRepository{

    @Override
    public Content update(Content content){
        getSession().update(content);
        getSession().flush();
        return content;
    }

    @Override
    public Content save(Content content){
        content.setUuid("content:"+ UUID.randomUUID().toString());
        getSession().save(content);
        getSession().flush();
        return content;
    }

    @Override
    public Content findUUID(String uuid) {
        Criteria criteria = getSession().createCriteria(Division.class)
                .setFetchMode(Layout_.creator.getName(), FetchMode.JOIN);
        criteria.add(Restrictions.eq(Layout_.uuid.getName() ,uuid));
        Content layout = (Content) criteria.uniqueResult();
        return layout;
    }
}
