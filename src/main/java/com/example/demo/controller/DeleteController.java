package com.example.demo.controller;


import com.example.demo.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteController", urlPatterns = {"/delete/*"})
public class DeleteController extends HttpServlet {
    private ProductService productService;
    public DeleteController() {
         this.productService = new ProductService();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        this.productService.deleteProduct(id);
        resp.sendRedirect("managerproducts");

    }
}
