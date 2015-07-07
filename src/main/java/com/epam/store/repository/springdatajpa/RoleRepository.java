package com.epam.store.repository.springdatajpa;

import com.epam.store.model.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Integer> {
    Role findByName(String roleName);
}
