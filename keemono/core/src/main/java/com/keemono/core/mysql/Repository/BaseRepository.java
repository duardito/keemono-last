package com.keemono.core.mysql.Repository;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;

/**
 * Created by edu on 01/11/2015.
 */
@Component
public class BaseRepository <M>{

    @Autowired
    private EntityManager entityManager;

    protected Session getSession(){
        final Session session = entityManager.unwrap(Session.class);
        session.setFlushMode(FlushMode.COMMIT);
        return session;
    }

}
