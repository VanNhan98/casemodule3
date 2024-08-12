package com.example.demo.controller;

import com.example.demo.domain.Account;
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

@WebServlet(name = "ManagerController", urlPatterns = {"/managerproducts/*"})
public class ManagerController extends HttpServlet {
    private ProductService productService;
    private CategoryService categoryService;

    public ManagerController() {
        this.productService = new ProductService();
        this.categoryService = new CategoryService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Account account = (Account) session.getAttribute("account");
        int sellId = account.getId();
        System.out.println("checkkkkkkk"+sellId);
        String intPage = req.getParameter("index");
        if(intPage == null) {
            intPage = "1";
        }

        int index = Integer.parseInt(intPage);
        int count = this.productService.getTotalProductBySellId(sellId);
        int endPage = count / 2 ;
        if(count % 2 != 0) {
            endPage++;
        }
        List<Product> list = this.productService.pagingProductBySellId(index, sellId);
        List<Category> listCategories = categoryService.getAllCategories();
        req.setAttribute("listProducts", list);
        req.setAttribute("listC", listCategories);
        req.setAttribute("endPage", endPage);
        req.setAttribute("tag", index);
        req.getRequestDispatcher("/views/manager.jsp").forward(req, resp);



    }
}
