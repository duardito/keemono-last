package com.keemono.service.user;

import com.keemono.core.mysql.domain.user.User;

import java.util.List;

/**
 * Created by edu on 03/06/2016.
 */
public interface IUserService {

    User createUser(User user);

    List<User> getUserList();
}
