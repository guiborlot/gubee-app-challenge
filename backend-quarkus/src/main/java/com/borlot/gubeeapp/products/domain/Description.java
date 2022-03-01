package com.borlot.gubeeapp.products.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Description {

    private String value;

    public Description(String description){
        this.value = description;
    }
}
