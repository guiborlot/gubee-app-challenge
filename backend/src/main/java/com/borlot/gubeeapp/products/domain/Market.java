package com.borlot.gubeeapp.products.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Market {
    private String value;

    public Market(String market){
        this.value = market;
    }
}
