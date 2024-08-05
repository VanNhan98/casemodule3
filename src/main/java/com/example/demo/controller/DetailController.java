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

@WebServlet(name = "DetailController", urlPatterns = {"/detail"})
public class DetailController extends HttpServlet {
    private ProductService productService;
    private CategoryService categoryService;

    public DetailController() {
        this.productService = new ProductService();
        this.categoryService = new CategoryService();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        // get data from the service
        Product product = this.productService.getProductDetailById(id);
        List<Category> listCategories = categoryService.getAllCategories();
        req.setAttribute("listCategories", listCategories);
        // push the product up to the view
        req.setAttribute("detail", product);
        // forward to the detail view (views/detail.jsp)
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/detail.jsp");
        requestDispatcher.forward(req, resp);
    }
}
