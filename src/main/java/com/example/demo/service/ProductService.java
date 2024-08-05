package com.example.demo.service;

import com.example.demo.database.DataConnect;
import com.example.demo.domain.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Product> getAllProducts() {
        List<Product> list = new ArrayList<>();
        // Fetch products from database and add them to the list
        String sql = "SELECT * FROM products ";
        try{
            conn = new DataConnect().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                Product product = new Product(rs.getInt("id"),
                        rs.getString("name")
                        , rs.getString("image")
                        , rs.getDouble("price")
                        , rs.getString("title")
                        , rs.getString("description"));
                list.add(product);
            }
        }catch(Exception e){

        }
        return list;
    }

    public List<Product> getProductById(String id) {
        List<Product> list = new ArrayList<>();
        // Fetch products from database and add them to the list
        String sql = "select * from products where cateid = ?; ";
        try{
            conn = new DataConnect().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while(rs.next()) {
                Product product = new Product(rs.getInt("id"),
                        rs.getString("name")
                        , rs.getString("image")
                        , rs.getDouble("price")
                        , rs.getString("title")
                        , rs.getString("description"));
                list.add(product);
            }
        }catch(Exception e){

        }
        return list;
    }


    public Product getProductDetailById(String id) {
        // Fetch products from database and add them to the list
        String sql = "select * from products where id = ?; ";
        try{
            conn = new DataConnect().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while(rs.next()) {
                return new Product(rs.getInt("id"),
                        rs.getString("name")
                        , rs.getString("image")
                        , rs.getDouble("price")
                        , rs.getString("title")
                        , rs.getString("description"));
            }
        }catch(Exception e){

        }
        return null;
    }



    public List<Product> searchProductByName(String nameSearch) {
        List<Product> list = new ArrayList<>();
        // Fetch products from database and add them to the list
        String sql = "select * from products where name like ?; ";
        try{
            conn = new DataConnect().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + nameSearch + "%");
            rs = ps.executeQuery();
            while(rs.next()) {
                Product product = new Product(rs.getInt("id"),
                        rs.getString("name")
                        , rs.getString("image")
                        , rs.getDouble("price")
                        , rs.getString("title")
                        , rs.getString("description"));
                list.add(product);
            }
        }catch(Exception e){

        }
        return list;
    }

    public static void main(String[] args) {
        ProductService productService = new ProductService();
        List<Product> list = productService.searchProductByName("dell");
        for(Product product : list) {
            System.out.println(product);
        }
    }
}
