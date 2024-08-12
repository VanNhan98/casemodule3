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
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "LoadController", urlPatterns = { "/load/*"})
public class LoadController extends HttpServlet {
    private ProductService productService;
    public LoadController() {
        this.productService = new ProductService();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int amount = Integer.parseInt(req.getParameter("exists"));
        List<Product> list = this.productService.getNextProducts(amount);
        PrintWriter out = resp.getWriter();
        for (Product o : list) {
            out.println("<div class=\"amount col-12 col-md-6 col-lg-4 mb-3\">\n" +
                    "    <div class=\"card h-100\">\n" +
                    "        <img class=\"card-img-top\" src=\"/image/" + o.getImage()+ "\" alt=\"Product Image\">\n" +
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
