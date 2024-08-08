package com.example.demo.controller;

import com.example.demo.domain.Account;
import com.example.demo.domain.Product;
import com.example.demo.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ManagerController", urlPatterns = {"/managerproducts/*"})
public class ManagerController extends HttpServlet {
    private ProductService productService;

    public ManagerController() {
        this.productService = new ProductService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Account account = (Account) session.getAttribute("account");
        int id = account.getId();
        List<Product> list = this.productService.getProductBySellId(id);
        req.setAttribute("lists", list);
        req.getRequestDispatcher("/views/manager.jsp").forward(req, resp);

    }
}
