package com.twuc.shopping.api;

import com.twuc.shopping.dto.AddItemDto;
import com.twuc.shopping.service.AddItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AddItemController {

    @Autowired
    AddItemService addItemService;

    @PostMapping("/addItem")
    @ResponseBody
    public ResponseEntity addItem(@RequestBody @Valid AddItemDto addItemDto) {
        return  addItemService.addItem(addItemDto);
//        return ResponseEntity.created(null).build();
    }
}
