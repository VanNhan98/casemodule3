//package com.example.demo.controller;
//
//
//import com.example.demo.domain.Category;
//import com.example.demo.domain.Product;
//import com.example.demo.service.CategoryService;
//import com.example.demo.service.ProductService;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.List;
//
//@WebServlet(name = "EditController", urlPatterns = { "/editProduct/*"})
//public class EditController extends HttpServlet {
//    private ProductService productService;
//    private CategoryService categoryService;
//    public EditController() {
//        this.productService = new ProductService();
//        this.categoryService = new CategoryService();
//    }
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String id = req.getParameter("id");
//        System.out.println("checking product"+id);
//        Product product = this.productService.getProductDetailById(id);
//        req.setAttribute("detail", product);
//        req.getRequestDispatcher("/views/manager.jsp").forward(req, resp);
//
//    }
//
//}
