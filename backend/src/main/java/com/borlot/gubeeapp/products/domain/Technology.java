package com.borlot.gubeeapp.products.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Technology {

    private String value;

    public Technology(String technology){
        this.value = technology;
    }
}
