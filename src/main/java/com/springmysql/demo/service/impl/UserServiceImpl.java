package com.springmysql.demo.service.impl;

import com.springmysql.demo.model.UserEntity;
import com.springmysql.demo.repo.UserRepository;
import com.springmysql.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserEntity getByName(String name) {
        return userRepository.findByName(name);
    }
}
