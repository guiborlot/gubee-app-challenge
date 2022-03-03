package com.borlot.gubeeapp.products.adapter.out.persistence.utils;

import javax.inject.Singleton;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

@Singleton
public class ProdDB implements DB{

    @Override
    public Properties loadProperties() {
        try (FileInputStream fs = new FileInputStream("db.properties")) {
            Properties props = new Properties();
            props.load(fs);
            return props;
        } catch (IOException e) {
            throw new DbException(e.getMessage());
        }
    }
}