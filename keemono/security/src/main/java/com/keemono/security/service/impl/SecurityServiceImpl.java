package com.keemono.security.service.impl;

import com.keemono.security.service.ISecurityService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by edu on 22/05/2016.
 */
@Service
public class SecurityServiceImpl implements ISecurityService {

    @Override
    public Boolean hasProtectedAccess() {

        List<SimpleGrantedAuthority> permissionsList = new ArrayList<>(0);
        permissionsList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        permissionsList.add(new SimpleGrantedAuthority("ROLE_USER"));
        permissionsList.add(new SimpleGrantedAuthority("ROLE_ROOT"));
/*
        Collection<? extends GrantedAuthority> authList = SecurityContextHolder.getContext().getAuthentication().getAuthorities();

        for (Object o : authList) {
            return permissionsList.contains(o);
        }
        */
        //(SecurityContextHolder.getContext().getAuthentication().getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN")));


        return SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream().filter(s -> permissionsList.contains(s)).findAny().isPresent();
    }

}
