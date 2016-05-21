package com.keemono.common.mapper;

import com.keemono.core.mysql.Repository.user.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by edu on 11/10/2015.
 */

public class BaseMapper {

    @Autowired
    protected CustomMapper mapper;

    @Autowired
    protected IUserRepository userRepository;


}
