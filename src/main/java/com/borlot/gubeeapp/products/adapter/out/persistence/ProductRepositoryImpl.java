package com.borlot.gubeeapp.products.adapter.out.persistence;

import com.borlot.gubeeapp.products.adapter.out.persistence.utils.DB;
import com.borlot.gubeeapp.products.application.port.in.ProductRepository;
import com.borlot.gubeeapp.products.domain.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {

    Connection conn = null;
    Statement st = null;
    ResultSet rs = null;

    @Override
    public List<Product> findAll() {
        try {
            conn = DB.getConnection();

            st = conn.createStatement();
            rs = st.executeQuery("select * from product");

            while(rs.next()){
                System.out.println(rs.getInt("ProductId") + "," + rs.getString("Name") + "," + rs.getString("Description"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
            DB.closeConnection();

        }
        return null;
    }

    @Override
    public List<Product> findByTechnology() {
        return null;
    }

    @Override
    public List<Product> findByMarket() {
        return null;
    }
}
