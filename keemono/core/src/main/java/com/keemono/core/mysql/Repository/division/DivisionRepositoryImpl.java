package com.keemono.core.mysql.Repository.division;

import com.keemono.core.mysql.Repository.BaseRepository;
import com.keemono.core.mysql.domain.division.Division;
import com.keemono.core.mysql.domain.layout.Layout_;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * Created by edu on 31/10/2015.
 */
@Repository
public class DivisionRepositoryImpl extends BaseRepository implements IDivisionRepository {

    @Override
    public List<Division> findAll(){
        Criteria criteria = getSession().createCriteria(Division.class)
                .setFetchMode(Layout_.creator.getName(), FetchMode.JOIN);
        return criteria.list();
    }

    @Override
    public Division update(Division layout){
        getSession().update(layout);
        getSession().flush();
        return layout;
    }

    @Override
    public Division save(Division division){
        division.setUuid("division:"+UUID.randomUUID().toString());
        getSession().save(division);
        getSession().flush();
        return division;
    }

    @Override
    public Division findUUID(String uuid) {
        Criteria criteria = getSession().createCriteria(Division.class)
                .setFetchMode(Layout_.creator.getName(), FetchMode.JOIN);
        criteria.add(Restrictions.eq(Layout_.uuid.getName() ,uuid));
        Division layout = (Division) criteria.uniqueResult();
        return layout;
    }

}
