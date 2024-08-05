package com.example.demo.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataConnect {
    private static final String URL = "jdbc:mysql://localhost:3306/store?useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";

    public DataConnect() {}

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connect database successfully");
        }catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public static void main(String[] args) {
        try {
            System.out.println(new DataConnect().getConnection());
        }catch (Exception e) {}
    }
}
