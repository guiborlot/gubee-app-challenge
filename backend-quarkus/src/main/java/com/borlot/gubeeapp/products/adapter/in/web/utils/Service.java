package com.borlot.gubeeapp.products.adapter.in.web.utils;

import com.borlot.gubeeapp.products.adapter.in.web.ProductDTO;

import java.util.List;

public class Service {
    public static List<ProductDTO> filter(List<ProductDTO> products, List<String> market, List<String> technologies){
         if(!market.isEmpty()){
             products = products.stream().filter(product -> market.stream().anyMatch(product.getMarket()::contains)).toList();
         }
         if(!technologies.isEmpty()){
             products = products.stream().filter(product -> product.getTechnologies().stream().anyMatch(technologies::contains)).toList();
         }
         return products;
    }
}
