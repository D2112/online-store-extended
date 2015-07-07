package com.epam.store.repository.springdatajpa;

import com.epam.store.model.Image;
import org.springframework.data.repository.CrudRepository;

public interface ImageRepository extends CrudRepository<Image, Integer> {

}
