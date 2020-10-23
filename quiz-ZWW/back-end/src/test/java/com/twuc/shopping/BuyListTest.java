package com.twuc.shopping;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.twuc.shopping.entity.AddItemEntity;
import com.twuc.shopping.entity.BuyListEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class BuyListTest {

    ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    MockMvc mockMvc;
    @Autowired
    com.twuc.shopping.repository.AddItemRepository addItemRepository;
    @Autowired
    com.twuc.shopping.repository.BuyListRepository buyListRepository;

    @BeforeEach
    public void init() {
        buyListRepository.deleteAll();
        addItemRepository.deleteAll();
        AddItemEntity addItemEntity1 = AddItemEntity.builder()
                .itemName("cola1")
                .itemPrice("1")
                .itemUnit("cup")
                .itemImgURL("../Item-Cola.jpg")
                .build();
        addItemRepository.save(addItemEntity1);
        AddItemEntity addItemEntity2 = AddItemEntity.builder()
                .itemName("cola2")
                .itemPrice("2")
                .itemUnit("bottle")
                .itemImgURL("../Item-Cola.jpg")
                .build();
        addItemRepository.save(addItemEntity2);
//        BuyListEntity buyListEntity1 = BuyListEntity.builder()
//                .buyName("cola1")
//                .buyPrice("1")
//                .buyUnit("cup")
//                .buyNum(1)
//                .build();
//        buyListRepository.save(buyListEntity1);
//        BuyListEntity buyListEntity2 = BuyListEntity.builder()
//                .buyName("cola2")
//                .buyPrice("2")
//                .buyUnit("bottle")
//                .buyNum(2)
//                .build();
//        buyListRepository.save(buyListEntity2);
    }

    @Test
    void should_add_item() throws Exception {
        BuyListEntity buyListEntity = BuyListEntity.builder()
                .buyName("cola1")
                .buyPrice("1")
                .buyUnit("cup")
                .buyNum(1)
                .build();
        String buyJson = objectMapper.writeValueAsString(buyListEntity);

        mockMvc.perform(post("/buyList/add")
                .content(buyJson).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        List<AddItemEntity> buyList = addItemRepository.findAll();

        assertEquals(1, buyList.size());
        assertEquals("cola1", buyList.get(2).getItemName());
    }
}
