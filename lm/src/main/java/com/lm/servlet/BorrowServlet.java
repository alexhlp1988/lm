package com.lm.servlet;

import com.lm.dao.BookBorrowDao;
import com.lm.dao.BorrowDao;
import com.lm.pojo.Borrow;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "BorrowServlet")
public class BorrowServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        String action = request.getParameter("action");
        action = (action == null) ? "list" : action;//默认执行查询操作
        System.out.println("您的操作是：" + action);


        if ("list".equals(action)) {


        } else if ("modify".equals(action)) {//申请借书
            BorrowDao borrowDao = new BorrowDao();
            System.out.println(request.getParameter("book_id") + "============");
            Integer book_id = Integer.parseInt(request.getParameter("book_id"));
            Integer user_id = (Integer) session.getAttribute("user_id");

            Borrow borrow = borrowDao.findBorrow(user_id, book_id);
            if (borrow != null) {
                if (borrow.getIs_back()!=0){
                    out.println("流程错误");
                    response.setHeader("refresh", "2;url=BookBorrowServlet");
                    return;
                } else {
                    borrow.setIs_back(2);//0代表未借出，1代表已借出，2代表审核中
                    int count = borrowDao.modify(borrow);
                }
            } else {
                borrow = new Borrow();
                borrow.setBook_id(book_id);
                borrow.setUser_id(user_id);
                borrow.setBack_date(new Date());
                borrow.setBorrow_date(new Date());
                borrow.setExpire_date(new Date());
                borrow.setIs_back(2);
                borrow.setManager("admin");
                borrowDao.add(borrow);
            }

            response.sendRedirect("BookBorrowServlet");
        } else if ("return".equals(action)) {//申请还书
            BorrowDao borrowDao = new BorrowDao();
            System.out.println(request.getParameter("book_id") + "============");
            Integer book_id = Integer.parseInt(request.getParameter("book_id"));
            Integer user_id = (Integer) session.getAttribute("user_id");

            Borrow borrow = borrowDao.findBorrow(user_id, book_id);
            if (borrow != null) {
                if (borrow.getIs_back()!=1){
                    out.println("流程错误");
                    response.setHeader("refresh", "2;url=BookBorrowServlet");
                    return;
                } else {
                    borrow.setIs_back(3);//0代表未借出，1代表已借出，2代表审核借书中,3代表审核还书中,4代表已归还
                    int count = borrowDao.modify(borrow);
                    response.sendRedirect("BookBorrowServlet");
                }
            } else {
                out.println("你没有借这本书");
                response.setHeader("refresh", "2;url=BookBorrowServlet");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
