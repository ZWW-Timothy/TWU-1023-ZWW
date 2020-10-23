package com.twuc.shopping.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.Valid;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BuyListDto {

    @NotEmpty
    private String buyName;

    @NotEmpty
    private String buyPrice;

    @NotEmpty
    private String buyUnit;

    @NotNull
    private Integer buyNum;

    @NotNull
    private int itemId;

    @JsonIgnore
    public int getItemId() {
        return itemId;
    }
}
