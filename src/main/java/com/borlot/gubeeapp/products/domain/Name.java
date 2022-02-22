package com.borlot.gubeeapp.products.domain;

import lombok.Getter;

@Getter
public class Name {
    private String value;

    public Name(String name){
        this.value = name;
    }
}
