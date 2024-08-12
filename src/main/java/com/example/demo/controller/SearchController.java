package com.example.demo.controller;


import com.example.demo.domain.Category;
import com.example.demo.domain.Product;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="SearchController", urlPatterns = {"/search/*"})
public class SearchController extends HttpServlet {

    private ProductService productService;
    private CategoryService categoryService;

    public SearchController() {
        this.productService = new ProductService();
        this.categoryService = new CategoryService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String search = req.getParameter("searchName");

        List<Product> list =  this.productService.searchProductByName(search);
        List<Category> listCategories = categoryService.getAllCategories();
        req.setAttribute("listC", listCategories);

        req.setAttribute("listProducts", list);
        req.setAttribute("nameDefault", search);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/home.jsp");
        requestDispatcher.forward(req, resp);

    }
}
