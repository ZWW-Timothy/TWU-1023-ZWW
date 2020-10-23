package com.twuc.shopping.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "add_item")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddItemEntity {
    @Id
    @GeneratedValue
    private Integer itemId;
    @Column(name = "name")
    private String itemName;
    @Column(name = "price")
    private String itemPrice;
    @Column(name = "unit")
    private String itemUnit;
    @Column(name = "imgURL")
    private String itemImgURL;
}
