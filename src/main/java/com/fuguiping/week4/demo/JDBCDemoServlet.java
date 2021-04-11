package com.fuguiping.week4.demo;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

//@WebServlet(

//urlPatterns = {"/jdbc"},
//initParams = {
//@WebInitParam(name="driver",value="com.microsoft.sqlserver.jdbc.SQLServerDriver"),
//@WebInitParam(name="url",value="jdbc:sqlserver://localhost;DatabaseName=userdb;"),
//@WebInitParam(name="username",value="sa"),
//@WebInitParam(name="password",value="123456"),

//},loadOnStartup = 1)

public class JDBCDemoServlet extends HttpServlet {
    Connection con = null;

    @Override
    public void init() throws ServletException {
        //String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        //String url="jdbc:sqlserver://localhost;DatabaseName=userdb;";
        //String username="sa";
        //String password="123456";

        ServletConfig config = getServletConfig();
        String driver = config.getInitParameter("driver");
        String url = config.getInitParameter("url");
        String username = config.getInitParameter("username");
        String password = config.getInitParameter("password");

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
            System.out.println("init()-->" + con);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("I am in doGet()");


        String id=null;
        String username=request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String birthDate = request.getParameter("birthDate");
        PrintWriter writer = response.getWriter();
        writer.println( "<table border=\"1\">"       +
                "<tr>"                   +
                "<td>id</td>"        +
                "<td>userName</td>"  +
                "<td>password</td>"  +
                "<td>email</td>"     +
                "<td>gender</td>"    +
                "<td>birthDate</td>" +
                "</tr>"    +
                "<tr>"     );
        try {
            Statement createDbStatement = con.createStatement();
            String selectDb="select * from usertable";
            ResultSet rs = createDbStatement.executeQuery(selectDb);
            while(rs.next()){
                id =rs.getString("id");
                username = rs.getString("userName");
                password = rs.getString("Password");
                email = rs.getString("email");
                gender = rs.getString("Gender");
                birthDate = rs.getString("BirthDate");
                writer.println(
                        "<td>" + id       + "</td>" +
                                "<td>" + username + "</td>" +
                                "<td>" + password  + "</td>" +
                                "<td>" + email     + "</td>" +
                                "<td>" + gender    + "</td>" +
                                "<td>" + birthDate + "</td>"+ "</tr>");
            }
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    @Override
    public void destroy() {
        super.destroy();
        try {
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
