package com.epam.store.repository.springdatajpa;

import com.epam.store.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Integer> {

    Category findByName(String name);

}
