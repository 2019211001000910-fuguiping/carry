package com.fuguiping.week3.demo;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "RegisterServlet",value = "/register")
class RegisterServlet extends HttpServlet {

    public Connection con;

    public void init() throws ServletException{
        super.init();
//        String driver = getServletContext().getInitParameter("driver");
//        String url = getServletContext().getInitParameter("url");
//        String username = getServletContext().getInitParameter("username");
//        String password = getServletContext().getInitParameter("password");
//
//        try{
//            Class.forName(driver);
//            con = DriverManager.getConnection(url, username, password);
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }
        con = (Connection) getServletContext().getAttribute("con");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        String Username = request.getParameter("Username");
        String Password = request.getParameter("Password");
        String Email = request.getParameter("Email");
        String Gender = request.getParameter("Gender");
        String BirthDate = request.getParameter("BirthDate");

        PrintWriter writer = response.getWriter();
        try {

            System.out.println("con:" + con);
            Statement createDbStatement = con.createStatement();
            String insertDb = "insert into usertable(Username,Password,Email,Gender,BirthDate) values('" + Username + "','" + Password + "','" + Email + "','" + Gender + "','" + BirthDate + "')";
            createDbStatement.executeUpdate(insertDb);
//            String selectDb = "select * from usertable";
//            ResultSet rs = createDbStatement.executeQuery(selectDb);
//            while(rs.next()) {
//                rs.getString("id");
//                rs.getString("UserName");
//                rs.getString("Password");
//                rs.getString("Email");
//                rs.getString("Gender");
//                rs.getString("BirthDate");
//            }
//            request.getRequestDispatcher("UserList.jsp").forward(request,response);

            response.sendRedirect("login");
        } catch (Exception e) {
            System.out.println(e);
        }

//        writer.println(
//                "<table border=\"1\">"       +
//                    "<tr>"                   +
//                        "<td>id</td>"        +
//                        "<td>UserName</td>"  +
//                        "<td>Password</td>"  +
//                        "<td>Email</td>"     +
//                        "<td>Gender</td>"    +
//                        "<td>BirthDate</td>" +
//                    "</tr>"    +
//                    "<tr>"     +
//                        "<td>" + id        + "</td>" +
//                        "<td>" + Username  + "</td>" +
//                        "<td>" + Password  + "</td>" +
//                        "<td>" + Email     + "</td>" +
//                        "<td>" + Gender    + "</td>" +
//                        "<td>" + BirthDate + "</td>" +
//                    "</tr>"    +
//                "</table>");
    }
//        writer.println("<br/>");
//        writer.println("<br/>Username: " + Username);
//        writer.println("<br/>Password: " + Password);
//        writer.println("<br/>Email: " + Email);
//        writer.println("<br/>Gender: " + Gender);
//        writer.println("<br/>BirthDate: "  + BirthDate);
//        writer.println("<br/>");
//
//        writer.close();

}