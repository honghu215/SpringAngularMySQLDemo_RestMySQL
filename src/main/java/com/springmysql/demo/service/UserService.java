package com.springmysql.demo.service;

import com.springmysql.demo.model.UserEntity;

public interface UserService {

    UserEntity getByName(String name);
}
