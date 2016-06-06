package com.keemono.controller.user;

import com.keemono.common.Constants;
import com.keemono.common.converter.request.user.CreateUserRequest;
import com.keemono.common.converter.response.layout.LayoutResponse;
import com.keemono.common.converter.response.page.ListPageResponse;
import com.keemono.common.converter.response.user.ListUserResponse;
import com.keemono.common.converter.response.user.UserResponse;
import com.keemono.common.mapper.BaseMapper;
import com.keemono.common.ordination.OrdinationRequest;
import com.keemono.common.pagination.PaginationRequest;
import com.keemono.core.mysql.domain.user.User;
import com.keemono.service.user.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by edu on 03/06/2016.
 */
@PreAuthorize("@securityService.hasProtectedAccess()")
@Api(value = "/user", description = "Operations to do about a layout")
@RequestMapping(value = Constants._USER_URL)
@RestController
public class UserController extends BaseMapper {

    @Autowired
    private IUserService userService;

    @ApiOperation(value = "create user", notes = "create a user", response = LayoutResponse.class)
    @ResponseStatus(value = HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST, produces = Constants._APPLICATION_JSON, consumes = Constants._APPLICATION_JSON)
    public UserResponse createUser(@ApiParam(value = "basic data to create a user", required = true)
                                   @RequestBody @Valid final CreateUserRequest createUserRequest) {

        User user = mapper.map(createUserRequest, User.class);
        user = userService.createUser(user);
        return mapper.map(user, UserResponse.class);
    }

    @ApiOperation(value = "get all user", notes = "get all users list", response = ListPageResponse.class)
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = Constants._LIST,method = RequestMethod.GET, produces = Constants._APPLICATION_JSON)
    public ListUserResponse getUsers(@ModelAttribute @Valid final PaginationRequest paginationRequest, @Valid final OrdinationRequest ordinationRequest){

        List<User> users = userService.getUserList();

        final ListUserResponse lista = new ListUserResponse();
        List<UserResponse> out = mapper.mapAsList(users, UserResponse.class);
        lista.addAll(out);
        return lista;
    }


}
