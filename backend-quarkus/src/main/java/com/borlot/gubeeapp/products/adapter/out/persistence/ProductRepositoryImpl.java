package com.borlot.gubeeapp.products.adapter.out.persistence;

import com.borlot.gubeeapp.products.adapter.out.persistence.utils.DB;
import com.borlot.gubeeapp.products.adapter.out.persistence.utils.ProdDB;
import com.borlot.gubeeapp.products.adapter.out.persistence.utils.Service;
import com.borlot.gubeeapp.products.application.port.in.ProductRepository;
import com.borlot.gubeeapp.products.application.service.AllProducts;
import com.borlot.gubeeapp.products.domain.Product;

import javax.inject.Singleton;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class ProductRepositoryImpl implements ProductRepository {

    Connection conn = null;
    Statement st = null;
    ResultSet rs = null;
    Service service = new Service();
    DB db;

    public ProductRepositoryImpl(DB db) {
        this.db = db;
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        try {
            conn = db.getConnection(conn);
            st = conn.createStatement();
            rs = st.executeQuery("""
                    select product.ProductId, product.Name, product.Description, market.Name, technology.Name
                    from product
                             left join productTechRelation on product.ProductId = productTechRelation.ProductId
                             left join technology on productTechRelation.TechId = technology.TechId
                             inner join market on product.MarketId = market.MarketId""");
            products.addAll(service.productBuilder(rs));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.closeResultSet(rs);
            db.closeStatement(st);
        }
        return products;
    }
}
