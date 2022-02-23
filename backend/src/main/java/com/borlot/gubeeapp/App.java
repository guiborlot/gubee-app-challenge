package com.borlot.gubeeapp;

import com.borlot.gubeeapp.products.adapter.in.web.ProductController;

import java.io.IOException;

public class App 
{
    public static void main( String[] args ) throws IOException {
        ProductController.rest();
    }
}
