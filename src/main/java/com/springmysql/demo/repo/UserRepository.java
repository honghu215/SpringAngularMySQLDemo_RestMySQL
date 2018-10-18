package com.springmysql.demo.repo;

import com.springmysql.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    public User findOneByName(String name);
}
