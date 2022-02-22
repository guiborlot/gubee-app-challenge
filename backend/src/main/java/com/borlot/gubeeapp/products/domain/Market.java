package com.borlot.gubeeapp.products.domain;

import lombok.Getter;

@Getter
public class Market {
    private String value;

    public Market(String market){
        this.value = market;
    }
}
