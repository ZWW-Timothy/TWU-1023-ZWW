package com.twuc.shopping.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "buy_list")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BuyListEntity {
    @Id
    @GeneratedValue
    private Integer buyId;
    @Column(name = "name")
    private String buyName;
    @Column(name = "price")
    private String buyPrice;
    @Column(name = "unit")
    private String buyUnit;
    @Column(name = "num")
    private int buyNum;
    private int itemId;
}
