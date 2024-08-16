package com.example.demo.controller;


import com.example.demo.domain.Category;
import com.example.demo.domain.Product;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EditController", urlPatterns = { "/editProduct/*"})
public class EditController extends HttpServlet {
    private ProductService productService;
    private CategoryService categoryService;
    public EditController() {
        this.productService = new ProductService();
        this.categoryService = new CategoryService();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id  = req.getParameter("id");
        System.out.println("cccccc"+id);
        Product product = this.productService.getProductDetailById(id);
        List<Category> categories = this.categoryService.getAllCategories();
        req.setAttribute("listC", categories);
        req.setAttribute("detail", product);

        req.getRequestDispatcher("views/edit.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String image = req.getParameter("image");
        double price = Double.parseDouble(req.getParameter("price"));
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        String categoryId = req.getParameter("category");
        this.productService.updateProduct(name, image, price,title,description,categoryId, Integer.parseInt(id));
        resp.sendRedirect("managerproducts");

    }
}
