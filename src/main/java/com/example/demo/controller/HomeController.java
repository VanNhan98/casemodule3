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
        // get list of products
        List<Product> listProducts = productService.getAllProducts();

        List<Category> listCategories = categoryService.getAllCategories();
        // push the products, categories up to the view
        req.setAttribute("listProducts", listProducts);
        req.setAttribute("listCategories", listCategories);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/home.jsp");
        requestDispatcher.forward(req, resp);
    }
}
