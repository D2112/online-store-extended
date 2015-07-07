package com.epam.store.repository.springdatajpa;

import com.epam.store.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Integer> {

    List<Product> findByCategoryName(String categoryName);

    Product findByName(String productName);

    @Query(value = "SELECT * FROM Product ORDER BY id DESC LIMIT ?1", nativeQuery = true)
    List<Product> getRecentProducts(int numberOfProducts);
}
