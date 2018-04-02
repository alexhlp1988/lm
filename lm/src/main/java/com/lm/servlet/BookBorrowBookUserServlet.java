package com.lm.servlet;

import com.lm.dao.BookBorrowBookUserDao;
import com.lm.pojo.BookBorrowBookUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
//借出归还需验证状态不能直接更新
@WebServlet(name = "BookBorrowBookUserServlet")
public class BookBorrowBookUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();
        String myrights = (String) session.getAttribute("rights");
        if (myrights == null) {//未登录时权限为null
            response.sendRedirect("back/noright.jsp");
            return;
        }
        Set<String> smyrights = new HashSet<>();
        String[] mmyrights = myrights.split(",");
        for (String s : mmyrights) {
            smyrights.add(s);//权限分别放入set
        }

        if (smyrights.contains("借还操作")) {
            String action = request.getParameter("action");
            action = (action == null) ? "list" : action; // 默认执行查询操作
            System.out.println("您的操作是: " + action);
            BookBorrowBookUserDao dao = new BookBorrowBookUserDao();
            String manager = (String) session.getAttribute("mname");
            if ("borrow".equals(action)) {//后台审核借书
                BookBorrowBookUser bookBorrowBookUser = new BookBorrowBookUser();
                String isbn = request.getParameter("barcode");
                String lc = request.getParameter("identiCode");
                int count = 0;
                bookBorrowBookUser.setIsbn(isbn);
                bookBorrowBookUser.setLibrary_card(lc);
                bookBorrowBookUser.setIs_back(1);
                bookBorrowBookUser.setManager(manager);
                count = dao.modify(bookBorrowBookUser);

                if (count > 0) {
                    System.out.println("借阅成功！");
                    response.sendRedirect("ShowBorrowedBookServlet");
                } else {
                    System.out.println("借阅失败！");
                    response.sendRedirect("ShowBorrowedBookServlet");
                }
            } else if ("return".equals(action)) {//后台审核还书
                BookBorrowBookUser bookBorrowBookUser = new BookBorrowBookUser();
                String isbn = request.getParameter("barcode");
                String lc = request.getParameter("identiCode");
                int count = 0;
                bookBorrowBookUser.setIsbn(isbn);
                bookBorrowBookUser.setLibrary_card(lc);
                bookBorrowBookUser.setIs_back(4);
                bookBorrowBookUser.setManager(manager);
                count = dao.modify(bookBorrowBookUser);

                if (count > 0) {
                    System.out.println("归还成功！");
                    response.sendRedirect("ShowBorrowedBookServlet");
                } else {
                    System.out.println("归还失败！");
                    response.sendRedirect("ShowBorrowedBookServlet");
                }
            } else if ("list".equals(action)) {
                BookBorrowBookUser bookBorrowBookUser = new BookBorrowBookUser();

            }
        } else {
            response.sendRedirect("back/noright.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
