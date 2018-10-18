package com.springmysql.demo.services;

import com.springmysql.demo.model.User;
import com.springmysql.demo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User save(User user) {
        return userRepository.saveAndFlush(user);
    }

    public User update(User user) {
        return userRepository.save(user);
    }

    public User find(String name) {
        return userRepository.findOneByName(name);
    }

}
