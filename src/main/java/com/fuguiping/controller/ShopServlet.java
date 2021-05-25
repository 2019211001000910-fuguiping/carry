package com.fuguiping.controller;

import com.fuguiping.dao.ProductDao;
import com.fuguiping.model.Category;
import com.fuguiping.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ShopServlet", value = "/shop")
public class ShopServlet extends HttpServlet {
    public Connection con;

    public void init() throws ServletException {
        super.init();
        con = (Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //set all category into request
        Category category = new Category();
        try {
            List<Category> categoryList = Category.findAllCategory(con);
            request.setAttribute("categoryList", categoryList);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //set all product into request
        try {
            ProductDao productDao = new ProductDao();
            if (request.getParameter("categoryId") == null) {
                List<Product> productList = productDao.findAll((Connection) getServletContext().getAttribute("con"));
                System.out.println(productList);
                request.setAttribute("productList", productList);
            } else {
                int catId = Integer.parseInt(request.getParameter("categoryId"));
                List<Product> productList = productDao.findByCategoryId(catId, con);
                request.setAttribute("productList", productList);

            }


        } catch (Exception e) {
            System.out.println(e);
        }
        //forward
        request.getRequestDispatcher("/WEB-INF/views/shop.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}