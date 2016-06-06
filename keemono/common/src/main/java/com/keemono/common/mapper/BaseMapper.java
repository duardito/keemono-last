package com.keemono.common.mapper;

import com.keemono.core.mysql.Repository.user.IUserRepository;
import com.keemono.core.mysql.domain.user.User;
import com.keemono.security.factory.CerberusUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by edu on 11/10/2015.
 */

public class BaseMapper {

    @Autowired
    protected CustomMapper mapper;

    @Autowired
    protected IUserRepository userRepository;

    protected User getLoggedUser(){
        return userRepository.findOne(getAuthenticatedUserUuid());
    }


    private String getAuthenticatedUserUuid(){
        final Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        final CerberusUser user = (CerberusUser) auth.getPrincipal();
        return user.getUuid();
    }



}
