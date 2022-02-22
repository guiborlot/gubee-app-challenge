package com.borlot.gubeeapp.products.domain;

import lombok.Getter;

@Getter
public class Technology {

    private String value;

    public Technology(String technology){
        this.value = technology;
    }
}
