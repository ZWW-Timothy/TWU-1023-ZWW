package com.twuc.shopping.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class BuyListController {

    private final com.twuc.shopping.repository.AddItemRepository addItemRepository;
    private final com.twuc.shopping.repository.BuyListRepository buyListRepository;

    public BuyListController(com.twuc.shopping.repository.AddItemRepository addItemRepository, com.twuc.shopping.repository.BuyListRepository buyListRepository) {
        this.addItemRepository = addItemRepository;
        this.buyListRepository = buyListRepository;
    }


    @PostMapping("/buyList/add")
    public ResponseEntity addBuy(@RequestBody @Valid com.twuc.shopping.entity.BuyListEntity buyList) {
        if (!buyListRepository.existsById(buyList.getBuyId())) {
            return  ResponseEntity.badRequest().build();
        }
        com.twuc.shopping.entity.BuyListEntity buyListEntity = com.twuc.shopping.entity.BuyListEntity.builder()
                .buyName(buyList.getBuyName())
                .buyPrice(buyList.getBuyPrice())
                .buyUnit(buyList.getBuyUnit())
                .buyNum(buyList.getBuyNum())
                .build();
        buyListRepository.save(buyListEntity);
        return ResponseEntity.created(null).build();
    }
}
