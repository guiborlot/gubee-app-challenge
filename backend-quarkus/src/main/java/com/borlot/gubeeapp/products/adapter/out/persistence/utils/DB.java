package com.borlot.gubeeapp.products.adapter.out.persistence.utils;

import java.sql.*;
import java.util.Properties;

public interface DB {
    Properties loadProperties();

    default Connection getConnection(Connection conn){
        if(conn == null){
            try{
                Properties props = loadProperties();
                String url = props.getProperty("dburl");
                conn = DriverManager.getConnection(url, props);
            } catch (SQLException e){
                throw new DbException(e.getMessage());
            }

        }
        return conn;
    }

    default void closeConnection(Connection conn){
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException e){
                throw new DbException(e.getMessage());
            }
        }
    }

    default void closeStatement(Statement st){
        if(st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

    default void closeResultSet(ResultSet rs){
        if(rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }
}
