package com.twuc.shopping.service;

import com.twuc.shopping.dto.AddItemDto;
import com.twuc.shopping.entity.AddItemEntity;
import com.twuc.shopping.repository.AddItemRepository;
import com.twuc.shopping.repository.BuyListRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Service
public class AddItemService {

    private final AddItemRepository addItemRepository;
    private final BuyListRepository buyListRepository;

    public AddItemService(AddItemRepository addItemRepository, BuyListRepository buyListRepository) {
        this.addItemRepository = addItemRepository;
        this.buyListRepository = buyListRepository;
    }

    @PostMapping("/addItem")
    public ResponseEntity addItem(@RequestBody @Valid AddItemDto addItem) {
        if (addItemRepository.findByName(addItem.getItemName()) != null) {
            return  ResponseEntity.badRequest().build();
        }
        AddItemEntity addItemEntity = AddItemEntity.builder()
                .itemName(addItem.getItemName())
                .itemPrice(addItem.getItemPrice())
                .itemUnit(addItem.getItemUnit())
                .itemImgURL(addItem.getItemImgURL())
                .build();
        addItemRepository.save(addItemEntity);
        return ResponseEntity.ok().build();
    }
}
