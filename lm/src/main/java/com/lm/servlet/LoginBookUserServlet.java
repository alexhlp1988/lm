package com.lm.servlet;

import com.lm.dao.BookBorrowDao;
import com.lm.dao.BookUserDao;
import com.lm.pojo.BookBorrow;
import com.lm.pojo.BookUser;
import com.lm.util.MD5;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


public class LoginBookUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();
        // 获取操作 (登录 | 注销)
        String action = request.getParameter("action");
        if ("login".equalsIgnoreCase(action)) {
            //1.登录
            //1.1获取用户名和密码
            String account = request.getParameter("account");
            String spassword = request.getParameter("password");
            String password = MD5.getMD5(spassword);
            BookUserDao dao = new BookUserDao();
            BookUser bookuser = dao.find(account, password);

            if (bookuser != null) {
                System.out.println("登录成功");
                action="list";
                session.setAttribute("user_id", bookuser.getId());

                BookBorrowDao bookBorrowDao =new BookBorrowDao();

                if("list".equals(action)){
                    //查询所有
                    List<BookBorrow> books=bookBorrowDao.findBook(bookuser.getId());
                    request.setAttribute("books",books);

                }
                //把用户名存到session
                session.setAttribute("account", account);
                // 1.5 若勾选 记住我 则把用户名存储到 cookie
                String rememberme = request.getParameter("rememberme");
                if (rememberme != null) {
                    System.out.println("勾选,记录 cookie");
                    Integer expiry = Integer.parseInt(request.getParameter("expiry"));
                    Cookie cookie = new Cookie("account", account);
                    cookie.setMaxAge(expiry);
                    response.addCookie(cookie);
                } else {
                    System.out.println("未勾选,不记录 cookie");
                }
                //转发
                request.getRequestDispatcher("front/showLiberInfoFront.jsp").forward(request,response);
               // request.getRequestDispatcher("BookUserServlet").forward(request,response);
            }else {
                System.out.println("错误的用户名或密码");
                out.println("<span style='color:red;'>错误的用户名或密码!</span>");
                // 停留 3 秒后重定向
                response.setHeader("refresh", "3;url=front/showLiberInfoFront.jsp");
            }
        } else if ("logout".equalsIgnoreCase(action)) {
            // 2.注销
            if (session.getAttribute("account") != null) {
                session.removeAttribute("account");
                session.invalidate();

            }
            response.sendRedirect("front/showLiberInfoFront.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
