package com.borlot.gubeeapp.products.domain;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
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
        this.id = id;
        this.name = name;
        this.description = description;
        this.market = market;
        this.addTechnologiesByString(technologies);
    }

    public void addTechnologiesByString(List<String> technologies){
        for(String tech: technologies){
            this.technologies.add(new Technology(tech));
        }
    }

    public void addTechnologiesByTech(List<Technology> technologies){
        for(Technology tech: technologies){
            this.technologies.add(new Technology(tech.getValue()));
        }
    }
}
