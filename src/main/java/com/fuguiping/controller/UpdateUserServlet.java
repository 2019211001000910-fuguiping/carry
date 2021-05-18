package com.fuguiping.controller;

import com.fuguiping.dao.UserDao;
import com.fuguiping.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Date;



@WebServlet(name = "UpdateUserServlet", value = "/updateUser")
public class UpdateUserServlet extends HttpServlet {
    Connection con=null;

    @Override
    public void init() throws ServletException {
        con = (Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String Email=request.getParameter("email");
        String gender=request.getParameter("gender");
        Date birthDate = Date.valueOf(request.getParameter("birthDate"));

        User us=new User(id,username,password,Email,gender,birthDate);
        us.setId(id);

        UserDao userDao=new UserDao();
        try {
            int user =userDao.updateUser(con,us);
            if (user !=0) {

                request.getRequestDispatcher("/login").forward(request, response);
            } else {
                System.out.println("你的修改不符合格式");
            }
        }
        catch(SQLException throwables){
            throwables.printStackTrace();
        }

    }

}
