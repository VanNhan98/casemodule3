package com.example.demo.controller;

import com.example.demo.domain.Account;
import com.example.demo.service.AccountService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "LoginController", urlPatterns = {"/login/*"})
public class LoginController extends HttpServlet {
    private AccountService accountService;

    public LoginController() {
        this.accountService = new AccountService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Lấy thông tin từ form
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Account account = this.accountService.login(username, password);
        // Kiểm tra thông tin đăng nhập
        if (account == null) {
            // Nếu thông tin sai, quay lại trang login với thông báo lỗi
            req.setAttribute("error", "Invalid username or password");
            req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("home");
        }
    }
}
