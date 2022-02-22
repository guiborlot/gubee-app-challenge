package com.borlot.gubeeapp.products.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Product {

    private Integer id;
    private Name name;
    private Description description;
    private Market market;
    private List<Technology> technologies = new ArrayList<>();

    public Product(Integer id, String name, String description, String market, List<String> technologies){
        this(id, new Name(name), new Description(description), new Market(market), technologies);
    }

    public Product(Integer id, Name name, Description description, Market market, List<String> technologies) {
        this.name = name;
        this.description = description;
        this.market = market;
        this.addTechnologies(technologies);
    }

    private void addTechnologies(List<String> technologies){
        for(String tech: technologies){
            this.technologies.add(new Technology(tech));
        }
    }
}
