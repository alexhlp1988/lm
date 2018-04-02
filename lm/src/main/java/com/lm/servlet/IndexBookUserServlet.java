package com.lm.servlet;

import com.lm.dao.BookUserDao;
import com.lm.pojo.BookUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "IndexBookUserServlet")
public class IndexBookUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        // 登录标记
        boolean flag = false;
        HttpSession session = request.getSession();
        // 1.获取客户端的所有的 cookie
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            if (session.getAttribute("account")==null) {
                for (Cookie cookie : cookies) {
                    // 2.获取当前网站的 cookie
                    if ("account".equals(cookie.getName()) && cookie.getValue() != null) {
                        BookUserDao dao = new BookUserDao();
                        System.out.println("已登录");
                        // 2.1 已登录则获取用户名存储到 session
                        session.setAttribute("account", cookie.getValue());

                        BookUser bookuser = dao.find(cookie.getValue());
                        session.setAttribute("user_id", bookuser.getId());
                        // 2.2 更改登录标记
                        flag = true;
                        break;
                    }
                }
            } else {
                flag = true;
            }
        }
        // 3.根据 flag 重定向
        String url = "";
        if (flag) {
            System.out.println("直接访问 BookUserServlet");
            url = "BookBorrowServlet";
        } else {
            System.out.println("未登录,请登录");
            url = "front/showLiberInfoFront.jsp";
        }
        response.sendRedirect(url);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
