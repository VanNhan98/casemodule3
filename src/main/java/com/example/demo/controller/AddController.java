package com.example.demo.controller;


import com.example.demo.domain.Account;
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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AddController", urlPatterns = {"/addProduct/*"})
public class AddController extends HttpServlet {
    private ProductService productService;
    private CategoryService categoryService;
    public AddController() {
        this.productService = new ProductService();
        this.categoryService = new CategoryService();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        List<Category> listCategories = categoryService.getAllCategories();
//        req.setAttribute("listC", listCategories);
//        req.getRequestDispatcher("/views/manager.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nameP = req.getParameter("name");
        String imageP = req.getParameter("image");
        String priceP = req.getParameter("price");
        String titleP = req.getParameter("title");
        String descriptionP = req.getParameter("description");
        String categoryIdP = req.getParameter("category");
        HttpSession session = req.getSession();
        Account account = (Account) session.getAttribute("account");
        int id = account.getId();
        System.out.println("checkkkkkkkkkkkkk"+id);
        this.productService.insertProduct(nameP, imageP, Double.parseDouble(priceP), titleP, descriptionP, categoryIdP, id);
        resp.sendRedirect("managerproducts");

    }
}
