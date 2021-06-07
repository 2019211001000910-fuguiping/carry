package com.fuguiping.controller;

import com.fuguiping.dao.ProductDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;

@WebServlet(name = "getImgServlet", value = "/getImg")
public class GetlmgServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        super.init();
        con=(Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        ProductDao productDao=new ProductDao();
        int id=0;
        if(request.getParameter("id")!=null){
            id= Integer.parseInt(request.getParameter("id"));
        }
        try{
            byte[] imgByte=new byte[0];
            imgByte = productDao.getPictureById(id,con);
            if (imgByte!=null){
                response.setContentType("image/bif");
                OutputStream os=response.getOutputStream();
                os.write(imgByte);
                os.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}