package com.twuc.shopping.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddItemDto {

    @NotEmpty
    private String itemName;

    @NotEmpty
    private String itemPrice;

    @NotEmpty
    private String itemUnit;

    @NotEmpty
    private String itemImgURL;
}
