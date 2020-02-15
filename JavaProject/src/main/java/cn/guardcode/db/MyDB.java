package cn.guardcode.db;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

public class MyDB {
    private static ComboPooledDataSource source = new ComboPooledDataSource();
    static {
        try {
            source.setDriverClass("com.mysql.jdbc.Driver");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        source.setJdbcUrl("jdbc:mysql://localhost:3306/recommender?useUnicode=true&characterEncoding=utf-8&autoReconnect=true");
        source.setUser("root");
        source.setPassword("toor");
    }
    /*static void init(){
        try {
            source.setDriverClass("com.mysql.jdbc.Driver");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        source.setJdbcUrl("jdbc:mysql://localhost:3306/recommender?useUnicode=true&characterEncoding=utf-8");
        source.setUser("root");
        source.setPassword("toor");
    }*/
    public static DataSource getDataSource(){
        /*try {
            Connection connection = source.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        return source;
    }
    public static void main(String[] args) {
        //init();
        try {
            System.out.println(source.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
