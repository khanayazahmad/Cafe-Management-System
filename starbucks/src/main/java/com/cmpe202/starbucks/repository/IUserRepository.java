package com.cmpe202.starbucks.repository;

import com.cmpe202.starbucks.model.User;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
