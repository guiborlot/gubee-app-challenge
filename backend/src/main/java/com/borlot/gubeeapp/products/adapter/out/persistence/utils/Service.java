package com.borlot.gubeeapp.products.adapter.out.persistence.utils;

import com.borlot.gubeeapp.products.domain.Product;
import com.borlot.gubeeapp.products.domain.Technology;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Service {

    public List<Product> productBuilder(ResultSet rs) throws SQLException {
        List<Product> products = new ArrayList<>();
        while(rs.next()){
            Product product = new Product(rs.getInt("product.ProductId"),
                    rs.getString("product.Name"),
                    rs.getString("product.Description"),
                    rs.getString("market.Name"),
                    Collections.singletonList(rs.getString("technology.Name")));
            products.add(product);
        }
        for(int i=0; i< products.size(); i++){
            if(Objects.equals(products.get(i).getId(), products.get(i + 1).getId())){
                products.get(i).addTechnologiesByTech(products.get(i+1).getTechnologies());
                products.remove(i+1);
            }
        }
        return products;
    }
}
