package com.twuc.shopping.repository;

import com.twuc.shopping.entity.AddItemEntity;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AddItemRepository extends CrudRepository<com.twuc.shopping.entity.AddItemEntity, Integer> {
    List<AddItemEntity> findAll();
    Optional<AddItemEntity> findById(Integer itemId);
    Optional<AddItemEntity> findByName(String itemName);
}
