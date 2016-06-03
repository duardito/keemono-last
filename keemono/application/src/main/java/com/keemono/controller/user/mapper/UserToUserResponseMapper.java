package com.keemono.controller.user.mapper;

import com.keemono.common.converter.response.user.UserResponse;
import com.keemono.common.mapper.CustomBaseMapper;
import com.keemono.core.mysql.domain.user.User;
import org.springframework.stereotype.Component;

/**
 * Created by edu on 03/06/2016.
 */
@Component
public class UserToUserResponseMapper extends CustomBaseMapper<User, UserResponse> {

    public UserToUserResponseMapper(){
        super();
    }
}
