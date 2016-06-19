package com.keemono.core.mysql.Repository.content;

import com.keemono.core.mysql.Repository.BaseRepository;
import com.keemono.core.mysql.domain.content.Content;
import com.keemono.core.mysql.domain.content.Content_;
import com.keemono.core.mysql.domain.user.User;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * Created by edu on 20/05/2016.
 */
@Repository
public class ContentRepositoryImpl extends BaseRepository implements IContentRepository{

    @Override
    public List<Content> findAllByCreator(User owner){
        Criteria criteria = getSession().createCriteria(Content.class)
                .setFetchMode(Content_.creator.getName(), FetchMode.JOIN);
        criteria.add(Restrictions.eq(Content_.creator.getName() ,owner));
        return criteria.list();
    }

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
        Criteria criteria = getSession().createCriteria(Content.class)
                .setFetchMode(Content_.creator.getName(), FetchMode.JOIN);
        criteria.add(Restrictions.eq(Content_.uuid.getName() ,uuid));
        Content layout = (Content) criteria.uniqueResult();
        return layout;
    }
}
