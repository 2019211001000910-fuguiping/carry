package com.fuguiping.controller;

import com.fuguiping.dao.OrderDao;
import com.fuguiping.dao.UserDao;
import com.fuguiping.model.Order;
import com.fuguiping.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/accountDetails")
public class AccountDetailsServlet extends HttpServlet {
    Connection con = null;

    public void init() throws ServletException {
        con = (Connection) getServletContext().getAttribute("con");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            User user = (User) session.getAttribute("user");
            int id = user.getId();
            UserDao dao = new UserDao();
            try {
                user = dao.findById(con, id);
                request.setAttribute("user", user);
                OrderDao orderDao = new OrderDao();
                List<Order> orderList = orderDao.findByUserId(con, id);
                request.setAttribute("orderList", orderList);
                request.getRequestDispatcher("WEB-INF/views/accountDetails.jsp").forward(request, response);
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            response.sendRedirect("login");
        }
    }
}
