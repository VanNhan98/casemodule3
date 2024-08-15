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
import java.io.PrintWriter;
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
        String id = req.getParameter("cid");
        List<Product> list = this.productService.getProductByCateId(id);
//         get list of categories
//        List<Category> listCategories = categoryService.getAllCategories();
//        req.setAttribute("listC", listCategories);
//        // push
//        req.setAttribute("listProducts", listProductsId);
//        req.setAttribute("tag", id);
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/home.jsp");
//        requestDispatcher.forward(req, resp);
        PrintWriter out = resp.getWriter();
        for (Product o : list) {
            out.println("<div class=\"amount col-12 col-md-6 col-lg-4 mb-3\">\n" +
                    "    <div class=\"card h-100\">\n" +
                    "        <img class=\"card-img-top\" src=\"/image/" + o.getImage() + "\" alt=\"Product Image\">\n" +
                    "        <div class=\"card-body\">\n" +
                    "            <h4 class=\"card-title show_txt\">\n" +
                    "                <a style=\"text-decoration: none; color: black; display: flex; justify-content: center; white-space: nowrap;\" href=\"detail?id=" + o.getId() + "\" title=\"View Product\">" + o.getName() + "</a>\n" +
                    "            </h4>\n" +
                    "            <div class=\"row\">\n" +
                    "                <div class=\"col d-flex justify-content-center\">\n" +
                    "                    <p class=\"btn btn-success\">" + o.getPrice() + " $</p>\n" +
                    "                </div>\n" +
                    "            </div>\n" +
                    "        </div>\n" +
                    "    </div>\n" +
                    "</div>");
        }
    }
}
