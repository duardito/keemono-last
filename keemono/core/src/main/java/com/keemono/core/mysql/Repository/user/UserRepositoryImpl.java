package com.keemono.core.mysql.Repository.user;

import com.keemono.core.mysql.Repository.BaseRepository;
import com.keemono.core.mysql.domain.user.User;
import com.keemono.core.mysql.domain.user.User_;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

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
}
