package com.borlot.gubeeapp.products.domain;

import lombok.Getter;

@Getter
public class Description {

    private String value;

    public Description(String description){
        this.value = description;
    }
}
