package com.example.demo.controller;


import com.example.demo.domain.Account;
import com.example.demo.service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LogoutController", urlPatterns = {"/signup/*"})
public class SignupController extends HttpServlet {
    private AccountService accountService;

    public SignupController() {
        this.accountService = new AccountService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/signup.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String repass = req.getParameter("repass");

        if (!password.equals(repass)) {
            req.setAttribute("errormatch", "password incorrect");
            req.getRequestDispatcher("/views/signup.jsp").forward(req, resp);
        } else {
            Account account = this.accountService.checkAccountExist(username);
            if (account == null) {
                this.accountService.signup(username, password);
                resp.sendRedirect("login");
            } else {
                req.setAttribute("errormatch", "\n" +
                        "User already exists");
                req.getRequestDispatcher("/views/signup.jsp").forward(req, resp);
            }
        }
    }
}
