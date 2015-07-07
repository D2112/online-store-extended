package com.epam.store.repository.springdatajpa;

import com.epam.store.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findFirstByEmail(String email);

    List<User> findByBannedTrue();

    List<User> findByBannedFalse();

}
