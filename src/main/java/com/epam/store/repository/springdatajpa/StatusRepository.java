package com.epam.store.repository.springdatajpa;

import com.epam.store.model.Status;
import org.springframework.data.repository.CrudRepository;

public interface StatusRepository extends CrudRepository<Status, Integer> {

    Status findByName(String name);
}
