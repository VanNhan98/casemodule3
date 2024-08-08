package com.example.demo.domain;

public class Account {
    private int id;
    private String username;
    private String password;
    private int sell;
    private int isadmin;
    public Account() {
    }

    public Account(int id, String username, String password, int sell, int isadmin) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.sell = sell;
        this.isadmin = isadmin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSell() {
        return sell;
    }

    public void setSell(int sell) {
        this.sell = sell;
    }

    public int getIsadmin() {
        return isadmin;
    }

    public void setIsadmin(int isadmin) {
        this.isadmin = isadmin;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", sell=" + sell +
                ", isadmin=" + isadmin +
                '}';
    }
}
