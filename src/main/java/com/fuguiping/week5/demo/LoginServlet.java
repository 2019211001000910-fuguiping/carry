package com.fuguiping.week5.demo;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebInitParam(name="LoginServlet",value="/login")
public class LoginServlet extends HttpServlet {
    //开始连接数据库
    Connection con=null;
    String driver;
    String url;
    String username;
    String password;
    @Override
    public void init() throws ServletException{
        ServletContext context=this.getServletContext();
        driver = context.getInitParameter("driver");
        url = context.getInitParameter("url");
        username = context.getInitParameter("username");
        password = context.getInitParameter("password");

        try{
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
            System.out.println("进入数据库init()-->"+con);//连接数据库成功
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        try {

//            HttpSession hs = request.getSession(true);
//            Statement createDbStatement = con.createStatement();

//            String user = "select * from usertable where username='xxx' and password='xxx'";
//            ResultSet rs = createDbStatement.executeQuery(user);
            Statement st = con.createStatement();
//          定义sql语句
            String user = "select * from usertable where username=" + "'" + username + "'" + "and password='" + password + "'";
//          使用resultset接受返回数据
            ResultSet rs = st.executeQuery(user);

            if (rs.next()){
                ((PrintWriter) writer).println("Login Success!!!</br>");
                writer.println("Welcome"+username);
            }else {
                writer.println("Username or Password error");
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
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
