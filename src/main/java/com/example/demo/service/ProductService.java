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

//    public List<Product> getProductBySellId(int id) {
//        List<Product> list = new ArrayList<>();
//        // Fetch products from database and add them to the list
//        String sql = "select * from products where sellId = ?; ";
//        try {
//            conn = new DataConnect().getConnection();
//            ps = conn.prepareStatement(sql);
//            ps.setInt(1, id);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                Product product = new Product(rs.getInt("id"),
//                        rs.getString("name")
//                        , rs.getString("image")
//                        , rs.getDouble("price")
//                        , rs.getString("title")
//                        , rs.getString("description"));
//                list.add(product);
//            }
//        } catch (Exception e) {
//
//        }
//        return list;
//    }

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

    public int getTotalProductBySellId(int sellId) {
        String sql = "SELECT COUNT(*) as total FROM products where sellId = ?;";
        try {
            conn = new DataConnect().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, sellId);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt("total");
            }
        } catch (Exception e) {
            System.out.println("Error executing"+e.getMessage());
        }
        return 0;
    }

    public List<Product> pagingProductBySellId (int index, int sellId) {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * " +
                "FROM products " +
                "WHERE sellId = ? " +
                "ORDER BY id " +
                "LIMIT 2 OFFSET ?;";
        try {
            conn = new DataConnect().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, sellId);
            ps.setInt(2, (index - 1) * 2);
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

        }catch (Exception e) {
            System.out.println("Error" +e.getMessage());
        }
        return list;
    }


    public List<Product> getProductsTop3() {
        List<Product> list = new ArrayList<>();
        // Fetch products from database and add them to the list
        String sql = "select * from products order by id limit 3; ";
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

    public List<Product> getNextProducts (int amount) {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT *\n" +
                "FROM products \n" +
                "ORDER BY id limit 3 offset ?";
        try {
            conn = new DataConnect().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, amount);
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

        }catch (Exception e) {
            System.out.println("Error" +e.getMessage());
        }
        return list;
    }
    public static void main(String[] args) {
        ProductService p = new ProductService();
        // pagingProductBySellId
        int index = 1;
        int sellId = 1;
        List<Product> products = p.pagingProductBySellId(index, sellId);
        for (Product product : products) {
            System.out.println(product);
        }
    }

}
