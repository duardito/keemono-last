package com.keemono.controller.user.mapper;

import com.keemono.common.converter.request.user.CreateUserRequest;
import com.keemono.common.mapper.CustomBaseMapper;
import com.keemono.core.mysql.domain.user.User;
import org.springframework.stereotype.Component;

/**
 * Created by edu on 03/06/2016.
 */
@Component
public class CreateUserRequestToUserMapper extends CustomBaseMapper<CreateUserRequest, User> {

    public CreateUserRequestToUserMapper(){
        super();
    }
}
