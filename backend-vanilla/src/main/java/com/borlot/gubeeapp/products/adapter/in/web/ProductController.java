package com.borlot.gubeeapp.products.adapter.in.web;

import com.borlot.gubeeapp.products.adapter.out.persistence.ProductRepositoryImpl;
import com.borlot.gubeeapp.products.application.service.AllProducts;
import com.google.gson.Gson;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class ProductController {
    public static void rest() throws IOException {
        AllProducts allProducts = new AllProducts(new ProductRepositoryImpl());

        int serverPort = 8085;
        HttpServer server = HttpServer.create(new InetSocketAddress(serverPort), 0);

        server.createContext("/products", exchange -> {
            if ("GET".equals(exchange.getRequestMethod())) {
                Gson gson = new Gson();
                String productJson = gson.toJson(allProducts.execute().stream().map(ProductDTO::new).toList());
                exchange.getResponseHeaders().set("Content-Type", "application/json");
                exchange.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
                exchange.sendResponseHeaders(200, productJson.getBytes().length);
                OutputStream output = exchange.getResponseBody();
                output.write(productJson.getBytes());
                output.flush();
            } else {
                exchange.sendResponseHeaders(405, -1);
            }
            exchange.close();
        });
        server.setExecutor(null);
        server.start();
    }
}
