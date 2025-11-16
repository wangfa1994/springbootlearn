package com.wf.springbootlearn.a01.oldServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/*
*  springboot 整合servlet ， ServletComponentScan 和 WebServlet 注解 + servlet类继承HttpServlet
* */

// http://127.0.0.1:8080/myServlet
@WebServlet(urlPatterns = "/myServlet")
public class MyServlet  extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("hello word");
    }
}
