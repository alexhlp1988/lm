package com.lm.servlet;

import com.lm.dao.BookWarningBackDao;
import com.lm.pojo.BookWarningBack;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@WebServlet(name = "BookWarningBackServlet")
public class BookWarningBackServlet extends HttpServlet {
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
            BookWarningBackDao dao = new BookWarningBackDao();
            if ("list".equals(action)) {
                List<BookWarningBack> books = dao.finddate();
                for (BookWarningBack b : books) {
                    System.out.println(b.getAccount() + "account");
                }
                request.setAttribute("books", books);
                request.getRequestDispatcher("back/WarningBack.jsp").forward(request, response);
            }
        } else {
            response.sendRedirect("back/noright.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
