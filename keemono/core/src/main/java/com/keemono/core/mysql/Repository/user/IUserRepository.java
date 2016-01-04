package com.keemono.core.mysql.Repository.user;

import com.keemono.core.mysql.domain.user.User;

import java.io.Serializable;

/**
 * Created by edu on 31/05/2015.
 */
public interface IUserRepository<M, S extends Serializable>{

    User findOne(String uuid);
}
