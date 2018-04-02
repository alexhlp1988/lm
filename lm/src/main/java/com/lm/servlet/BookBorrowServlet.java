package com.lm.servlet;

import com.lm.dao.BookBorrowDao;
import com.lm.pojo.Book;
import com.lm.pojo.BookBorrow;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


public class BookBorrowServlet extends HttpServlet {
    private static final long serialVersionUID = 1730340707301052682L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String action = request.getParameter("action");
        action=(action==null)?"list":action;//默认执行查询操作
        System.out.println("您的操作是："+action);
        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("user_id");

        BookBorrowDao dao =new BookBorrowDao();

        if("list".equals(action)){
            //查询所有
            List<BookBorrow> books=dao.findBook(userId);
            request.setAttribute("books",books);
            request.getRequestDispatcher("front/showLiberInfoFront.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            this.doPost(request,response);
    }
}
