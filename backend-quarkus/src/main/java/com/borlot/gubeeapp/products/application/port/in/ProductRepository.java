package com.borlot.gubeeapp.products.application.port.in;

import com.borlot.gubeeapp.products.domain.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
}
