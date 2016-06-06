package com.keemono.service.user.impl;

import com.keemono.core.mysql.Repository.user.IUserRepository;
import com.keemono.core.mysql.domain.user.User;
import com.keemono.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by edu on 03/06/2016.
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public User createUser(User user) {
        user.setAuthorities("ROLE_USER");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class , readOnly = true)
    public List<User> getUserList() {
        return userRepository.findAll();
    }
}
