package com.fuguiping.week5.demo;

import com.fuguiping.dao.UserDao;
import com.fuguiping.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

//@WebServlet(name = "LoginServlet", value = "/LoginServlet")
@WebServlet(
        urlPatterns = {"/login"},
        loadOnStartup = 4
)
public class LoginServlet extends HttpServlet {
    //开始连接数据库
    Connection con=null;
    //    String driver;
//    String url;
//    String username;
//    String password;
    @Override
    public void init() throws ServletException {

        con = (Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");

        UserDao userDao=new UserDao();
        try {
            User user =userDao.findByUsernamePassword(con,username,password);
            if (user!=null){
                String RememberMe=request.getParameter("RememberMe");
                if(RememberMe!=null && RememberMe.equals("1")){
                    Cookie usernameCookie =new Cookie("cUsername", user.getUsername());
                    Cookie passwordCookie =new Cookie("cPassword", user.getPassword());
                    Cookie RememberMeCookie =new Cookie("cRememberMe",RememberMe);

                    usernameCookie.setMaxAge(5);
                    passwordCookie.setMaxAge(5);
                    RememberMeCookie.setMaxAge(5);

                    response.addCookie(usernameCookie);
                    response.addCookie(passwordCookie);
                    response.addCookie(RememberMeCookie);
                }

                HttpSession session=request.getSession();
                System.out.println("session id--->"+session.getId());
                session.setMaxInactiveInterval(10);
//                Cookie c=new Cookie("sessionid",""+user.getId());
//                c.setMaxAge(10*60);
//                response.addCookie(c);

                session.setAttribute("user",user);
                request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);
            }else {
                request.setAttribute("message","Username or Password Error !!!");
                request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

    }



}