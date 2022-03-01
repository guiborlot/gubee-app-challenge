package com.borlot.gubeeapp.products.adapter.in.web;

import com.borlot.gubeeapp.products.adapter.in.web.utils.Service;
import com.borlot.gubeeapp.products.adapter.out.persistence.ProductRepositoryImpl;
import com.borlot.gubeeapp.products.application.service.AllProducts;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/products")
public class ProductController {

    AllProducts allProducts = new AllProducts(new ProductRepositoryImpl());

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listProducts(@QueryParam("market") List<String> market, @QueryParam("technology") List<String> technologies){
        List<ProductDTO> products = allProducts.execute().stream().map(ProductDTO::new).toList();
        products = Service.filter(products, market, technologies);
        return Response.ok(products).build();
    }
}
