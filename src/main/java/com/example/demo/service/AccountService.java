package com.example.demo.service;

import com.example.demo.database.DataConnect;
import com.example.demo.domain.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccountService {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public Account login(String username, String password) {
        String sql = "SELECT * FROM accounts WHERE username =? AND password =?";
        try {
            conn = DataConnect.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                Account account = new Account(rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getInt("sell"),
                        rs.getInt("admin"));
                return account;
            }

        }catch(Exception e) {

        }
        return null;
    }

}
