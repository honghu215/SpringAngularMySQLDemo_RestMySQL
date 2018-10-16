package com.springmysql.demo.repo;

import com.springmysql.demo.model.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

    UserEntity findByName(String name);
}
