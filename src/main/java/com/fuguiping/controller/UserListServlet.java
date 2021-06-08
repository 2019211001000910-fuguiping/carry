package com.fuguiping.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/admin/userList")
public class UserListServlet extends HttpServlet {
    Connection con = null;

    public void init() throws ServletException {
        con = (Connection) getServletContext().getAttribute("con");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = "/WEB-INF/views/admin/userList.jsp";
        request.getRequestDispatcher(path).forward(request, response);
    }
}
