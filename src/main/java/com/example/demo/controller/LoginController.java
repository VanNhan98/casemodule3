package com.example.demo.controller;

import com.example.demo.domain.Account;
import com.example.demo.service.AccountService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;


@WebServlet(name = "LoginController", urlPatterns = {"/login/*"})
public class LoginController extends HttpServlet {
    private AccountService accountService;

    public LoginController() {
        this.accountService = new AccountService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] arr = req.getCookies();
//        if(arr != null) {
            for (Cookie c : arr) {
                if (c.getName().equals("userC") ) {
                    req.setAttribute("username", c.getValue());

                }
                if(c.getName().equals("passC")) {
                    req.setAttribute("password", c.getValue());
                }
            }
//        }


        req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Lấy thông tin từ form
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String remember = req.getParameter("remember");
        Account account = this.accountService.login(username, password);
        // Kiểm tra thông tin đăng nhập
        if (account == null) {
            // Nếu thông tin sai, quay lại trang login với thông báo lỗi
            req.setAttribute("error", "Invalid username or password");
            req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
        } else {
            HttpSession session = req.getSession();
            session.setAttribute("account", account);
//            session.setMaxInactiveInterval(1000);
            Cookie userC = new Cookie("userC", username);
            Cookie passC = new Cookie("passC", password);
            if(remember != null) {
                userC.setMaxAge(20);
                passC.setMaxAge(20);
            }
            else {
                userC.setMaxAge(0);
                passC.setMaxAge(0);
            }
            resp.addCookie(userC);
            resp.addCookie(passC);
            resp.sendRedirect("home");
        }
    }
}
