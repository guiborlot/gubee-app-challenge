package com.borlot.gubeeapp.products.adapter.out.persistence.utils;

import com.borlot.gubeeapp.products.domain.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        return joinTechnologiesWithSameProduct(products);
    }

    private List<Product> joinTechnologiesWithSameProduct(List<Product> products){
        for(int i=0; i< products.size(); i++){
            for(int j=i+1; j<products.size(); j++){
                if(products.get(i).getId().equals(products.get(j).getId())){
                    products.get(i).addTechnologiesByTech(products.get(j).getTechnologies());
                    products.remove(j);
                    j--;
                }
            }
        }
        return products;
    }
}
