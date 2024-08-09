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


@WebServlet(name = "CategoryController", urlPatterns = {"/category/*"})
public class CategoryController extends HttpServlet {
    private ProductService productService;
    private CategoryService categoryService;

    public CategoryController() {
        this.productService = new ProductService();
        this.categoryService = new CategoryService();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // get id of product
        String id = req.getParameter("id");
        List<Product> listProductsId = this.productService.getProductByCateId(id);
        // get list of categories
        List<Category> listCategories = categoryService.getAllCategories();
        req.setAttribute("listC", listCategories);
        // push
        req.setAttribute("listProducts", listProductsId);
        req.setAttribute("tag", id);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/home.jsp");
        requestDispatcher.forward(req, resp);

    }
}
