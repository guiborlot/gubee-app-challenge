package com.borlot.gubeeapp.utils;

import com.borlot.gubeeapp.products.adapter.out.persistence.utils.DB;
import com.borlot.gubeeapp.products.adapter.out.persistence.utils.DbException;
import io.quarkus.arc.Priority;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Priority(1)
@Alternative
@ApplicationScoped
public class TestDB implements DB {

    @Override
    public Properties loadProperties() {
        try (FileInputStream fs = new FileInputStream("test-db.properties")) {
            Properties props = new Properties();
            props.load(fs);
            return props;
        } catch (IOException e) {
            throw new DbException(e.getMessage());
        }
    }
}
