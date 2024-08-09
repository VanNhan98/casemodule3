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
        try {
            conn = new DataConnect().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product(rs.getInt("id"),
                        rs.getString("name")
                        , rs.getString("image")
                        , rs.getDouble("price")
                        , rs.getString("title")
                        , rs.getString("description"));
                list.add(product);
            }
        } catch (Exception e) {

        }
        return list;
    }

    public List<Product> getProductByCateId(String id) {
        List<Product> list = new ArrayList<>();
        // Fetch products from database and add them to the list
        String sql = "select * from products where cateid = ?; ";
        try {
            conn = new DataConnect().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product(rs.getInt("id"),
                        rs.getString("name")
                        , rs.getString("image")
                        , rs.getDouble("price")
                        , rs.getString("title")
                        , rs.getString("description"));
                list.add(product);
            }
        } catch (Exception e) {

        }
        return list;
    }


    public Product getProductDetailById(String id) {
        // Fetch products from database and add them to the list
        String sql = "select * from products where id = ?; ";
        try {
            conn = new DataConnect().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(rs.getInt("id"),
                        rs.getString("name")
                        , rs.getString("image")
                        , rs.getDouble("price")
                        , rs.getString("title")
                        , rs.getString("description"));

            }
        } catch (Exception e) {
            System.out.println("Error executing"+e.getMessage());
        }
        return null;
    }

    public List<Product> getProductBySellId(int id) {
        List<Product> list = new ArrayList<>();
        // Fetch products from database and add them to the list
        String sql = "select * from products where sellId = ?; ";
        try {
            conn = new DataConnect().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product(rs.getInt("id"),
                        rs.getString("name")
                        , rs.getString("image")
                        , rs.getDouble("price")
                        , rs.getString("title")
                        , rs.getString("description"));
                list.add(product);
            }
        } catch (Exception e) {

        }
        return list;
    }

    public void insertProduct(String name, String image, double price, String title,
                                 String description, String category, int sid) {
        String sql = "  INSERT INTO Products (name, image, price, title, description, cateId, sellId) \n" +
                "VALUES \n" +
                "    (?,?,?,?,?,?,?)";
        try {
            conn = new DataConnect().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setDouble(3, price);
            ps.setString(4, title);
            ps.setString(5, description);
            ps.setString(6, category);
            ps.setInt(7, sid);
            ps.executeUpdate();
            System.out.println("Product inserted successfully!");
        } catch (Exception e) {
            System.out.println("Product error: " + e.getMessage());
        }
    }

    public void deleteProduct(String id) {
        String sql = " delete from products where id = ?";
        try {
            conn = new DataConnect().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {

        }
    }

    public List<Product> searchProductByName(String nameSearch) {
        List<Product> list = new ArrayList<>();
        // Fetch products from database and add them to the list
        String sql = "select * from products where name like ?; ";
        try {
            conn = new DataConnect().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + nameSearch + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product(rs.getInt("id"),
                        rs.getString("name")
                        , rs.getString("image")
                        , rs.getDouble("price")
                        , rs.getString("title")
                        , rs.getString("description"));
                list.add(product);
            }
        } catch (Exception e) {

        }
        return list;
    }

    public void updateProduct(String name, String image, double price, String title,
                              String description, String category, int eid) {
        String sql = "  UPDATE products SET name =?, image =?,  price =?, title =?, description =?, cateId =? WHERE id =? ";
        try {
            conn = new DataConnect().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setDouble(3, price);
            ps.setString(4, title);
            ps.setString(5, description);
            ps.setString(6, category);
            ps.setInt(7, eid);
            ps.executeUpdate();
            System.out.println("Product inserted successfully!");
        } catch (Exception e) {
            System.out.println("Product error: " + e.getMessage());
        }
    }
}
