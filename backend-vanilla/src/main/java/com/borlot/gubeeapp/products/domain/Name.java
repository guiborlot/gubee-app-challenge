package com.borlot.gubeeapp.products.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Name {
    private String value;

    public Name(String name){
        this.value = name;
    }
}
