package com.keemono.core.mysql.Repository.user;

import com.keemono.core.mysql.Repository.BaseRepository;
import com.keemono.core.mysql.domain.user.User;
import com.keemono.core.mysql.domain.user.User_;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Created by edu on 01/11/2015.
 */
@Repository
public class UserRepositoryImpl extends BaseRepository implements IUserRepository {

    @Override
    public User findOne(String uuid) {
        Criteria criteria = getSession().createCriteria(User.class);
        criteria.add(Restrictions.eq(User_.uuid.getName(), uuid));
        User user = (User) criteria.uniqueResult();
        return user;
    }

    @Override
    public User save(User user) {
        user.setUuid("user:"+ UUID.randomUUID().toString());
        getSession().save(user);
        getSession().flush();
        return user;
    }

    @Override
    public User findByUsername(String username) throws Exception {
        Criteria criteria = getSession().createCriteria(User.class);
        criteria.add(Restrictions.eq(User_.username.getName(), username));
        try {
            User user = (User) criteria.uniqueResult();
            return user;
        }catch (Exception e){
            System.out.println(e.getCause());
            throw new Exception(e);
        }


    }
}
