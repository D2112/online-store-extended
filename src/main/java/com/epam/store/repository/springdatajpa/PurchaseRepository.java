package com.epam.store.repository.springdatajpa;

import com.epam.store.model.Purchase;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PurchaseRepository extends CrudRepository<Purchase, Integer> {

    /*@Query(value = "SELECT * FROM purchase WHERE user_id = ?1", nativeQuery = true)*/
    List<Purchase> findAllByUserID(int userID);

}
