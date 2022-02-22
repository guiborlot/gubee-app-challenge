package com.borlot.gubeeapp.products.application.service;

import com.borlot.gubeeapp.products.application.port.in.ProductRepository;
import com.borlot.gubeeapp.products.domain.Product;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class ProductsByTechnology {
    private ProductRepository repository;

    public List<Product> execute(){
        return repository.findByTechnology();
    }
}
