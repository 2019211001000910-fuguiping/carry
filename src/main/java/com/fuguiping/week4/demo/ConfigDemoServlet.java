package com.fuguiping.week4.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class ConfigDemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //response.setContentType("text/html;charset=utf-8");
        //PrintWriter printWriter = response.getWriter();
        //printWriter.println(" name :fuguiping<br>");
        //printWriter.println(" studentid :2019211001000910");
        PrintWriter out = response.getWriter();
        ServletConfig config=getServletConfig();
        String username=config.getInitParameter("username");
        String studentId=config.getInitParameter("studentId");
        out.println("<html><body>");
        out.println("username : " + username +"</br>");
        out.println("studentId : " + studentId + "</br>");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
