package com.borlot.gubeeapp.products.adapter.in.web;

import com.borlot.gubeeapp.products.domain.Product;
import com.borlot.gubeeapp.products.domain.Technology;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {
    private Integer id;
    private String name;
    private String description;
    private String market;
    private List<String> technologies;

    public ProductDTO(Product product){
        this(product.getId(), product.getName().getValue(), product.getDescription().getValue(), product.getMarket().getValue(),
                product.getTechnologies().stream().map(Technology::getValue).toList());
    }

    public Product toProduct(){
        return new Product(id, name, description, market, technologies);
    }
}
