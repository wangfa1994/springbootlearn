package com.wf.springbootlearn.a01.oldServlet;

/*
*  servlet 3.0 异步的servlet
* */

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
*  异步非阻塞的servlet
* @WebServlet 注解默认是false
* */
@WebServlet(urlPatterns = "/asynMyServlet",asyncSupported = true)
public class AsynMyServlet  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        f3(req, resp);


    }


    /* 这种方式会进行长时间的等待超时*/
    private static void f1(HttpServletRequest req, HttpServletResponse resp) {
        // 异步上下文
        AsyncContext asyncContext = req.startAsync();

        asyncContext.start(new Runnable() {
            @Override
            public void run() {
                try {
                    resp.getWriter().println("hello word");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    private static void f2(HttpServletRequest req, HttpServletResponse resp) {
        // 异步上下文
        AsyncContext asyncContext = req.startAsync();

        asyncContext.start(new Runnable() {
            @Override
            public void run() {
                try {
                    resp.getWriter().println("hello word");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        /* 触发完成，但是这种不会输出内容*/
        asyncContext.complete();

    }

    private static void f3(HttpServletRequest req, HttpServletResponse resp) {
        // 异步上下文
        AsyncContext asyncContext = req.startAsync();

        asyncContext.start(new Runnable() {
            @Override
            public void run() {
                try {
                    resp.getWriter().println("hello word");


                    /* 在异步中触发完成*/
                    asyncContext.complete();

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });



    }
}
