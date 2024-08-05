package com.example.demo.service;

import com.example.demo.database.DataConnect;
import com.example.demo.domain.Category;
import com.example.demo.domain.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoryService {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Category> getAllCategories() {
        List<Category> list = new ArrayList<>();
        // Fetch products from database and add them to the list
        String sql = "SELECT * FROM categories  ";
        try{
            conn = new DataConnect().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                Category category = new Category(rs.getInt("id"),
                        rs.getString("name"));
                list.add(category);
            }
        }catch(Exception e){
        }
        return list;
    }



}
