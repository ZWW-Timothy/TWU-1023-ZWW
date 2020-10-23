package com.twuc.shopping.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BuyListRepository extends CrudRepository<com.twuc.shopping.entity.BuyListEntity, Integer> {
    List<com.twuc.shopping.entity.BuyListEntity> findAll();
    Optional<com.twuc.shopping.entity.BuyListEntity> findById(Integer buyId);
}
