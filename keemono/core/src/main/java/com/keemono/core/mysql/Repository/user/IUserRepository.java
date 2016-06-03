package com.keemono.core.mysql.Repository.user;

import com.keemono.core.mysql.domain.user.User;

import java.io.Serializable;
import java.util.List;

/**
 * Created by edu on 31/05/2015.
 */
public interface IUserRepository<M, S extends Serializable>{

    User findOne(String uuid);

    User save(User user);

    User findByUsername(String username) throws Exception;

    List<User> findAll();
}
