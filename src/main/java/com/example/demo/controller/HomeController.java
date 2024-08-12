package com.example.demo.controller;


import com.example.demo.domain.Category;
import com.example.demo.domain.Product;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeController", urlPatterns = {"/home/*"})
public class HomeController extends HttpServlet {

    private ProductService productService;
    private CategoryService categoryService;


    public HomeController() {
        this.productService = new ProductService();
        this.categoryService = new CategoryService();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> list = this.productService.getProductsTop3();
        List<Category> categories = this.categoryService.getAllCategories();
        req.setAttribute("listProducts", list);
        req.setAttribute("listC", categories);
        req.getRequestDispatcher("views/home.jsp").forward(req, resp);

    }

}
