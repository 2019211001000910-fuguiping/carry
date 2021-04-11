package com.fuguiping.week3.demo;


import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

//@WebServlet(name = "registerServlet", value = "/registerServlet")
@WebServlet(
        urlPatterns = {"/register"},
        loadOnStartup = 3
)
class registerServlet extends HttpServlet {
    Connection con=null;
    String driver;
    String url;
    String username;
    String password;


    public void init() throws ServletException{
        ServletContext context=this.getServletContext();
        driver = context.getInitParameter("driver");
        url = context.getInitParameter("url");
        username = context.getInitParameter("username");
        password = context.getInitParameter("password");

        System.out.println("1");
        try{
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
            System.out.println("查看用户信息 init()-->"+con);//成功
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = null;
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String birthDate = request.getParameter("birthDate");

//
//
//        PrintWriter writer = response.getWriter();
//        writer.println("<br> username :"+username);
//        writer.println("<br> password :"+password);
//        writer.println("<br> Email :"+Email);
//        writer.println("<br> gender :"+gender);
//        writer.println("<br> birthDate :"+birthDate);
//        writer.close();


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
            String insertDb = "insert into userdb.dbo.usertable(username,password,email,gender,birthDate) values('"+username+"','"+password+"','"+email+"','"+gender+"','"+birthDate+"')";
            createDbStatement.executeUpdate(insertDb);
            String selectDb = "select * from userdb.dbo.usertable";
            ResultSet rs = createDbStatement.executeQuery(selectDb);
            while(rs.next()) {
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
                                "<td>" + birthDate + "</td>"+ "</tr>"
                );
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        writer.println("</table>");

    }

    @Override
    public void destroy() {
        super.destroy();
        try {
            con.close();//当tomcat停止时释放内存
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

