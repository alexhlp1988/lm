package com.lm.servlet;

import com.lm.dao.BookUserTypeDao;
import com.lm.pojo.BookUserType;

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


public class BookUserTypeServlet extends HttpServlet {
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

        if (smyrights.contains("读者操作")) {
            String action = request.getParameter("action");
            action = (action == null) ? "list" : action;//默认执行查询操作
            System.out.println("您的操作是：" + action);

            BookUserTypeDao dao = new BookUserTypeDao();

            if ("list".equals(action)) {
                //查询所有
                List<BookUserType> bookUserTypes = dao.find();
                request.setAttribute("bookUserTypes", bookUserTypes);
                request.getRequestDispatcher("back/showAllReaderType.jsp").forward(request, response);

            } else if ("add".equals(action)) {
                String id = request.getParameter("id");
                String typename = request.getParameter("name");
                String book_count = request.getParameter("quantity");
                //封装表单数据到对象
                BookUserType bookUserType = new BookUserType();
                bookUserType.setTypename(typename);
                bookUserType.setBook_count(Integer.parseInt(book_count));

                int count = 0;
                count = dao.add(bookUserType);
                if (count > 0) {
                    response.sendRedirect("BookUserTypeServlet");
                    System.out.println("增加成功");
                } else {
                    //增加失败
                    response.setHeader("refresh", "2;url=BookUserTypeServlet");
                }
            } else if ("findById".equals(action)) {
                Integer id = Integer.parseInt(request.getParameter("id"));
                BookUserType bookUserType = dao.findById(id);
                if (bookUserType != null) {
                    request.setAttribute("bookUserType", bookUserType);
                    request.getRequestDispatcher("back/updateReaderType.jsp").forward(request, response);
                }
            }

            //修改
            else if ("modify".equals(action)) {
                String id = request.getParameter("id");
                String typename = request.getParameter("name");
                String book_count = request.getParameter("quantity");

                BookUserType bookUserType = dao.findById(Integer.parseInt(id));

                bookUserType.setId(Integer.parseInt(id));
                bookUserType.setTypename(typename);
                bookUserType.setBook_count(Integer.parseInt(book_count));

                int count = 0;
                count = dao.modify(bookUserType);
                if (count > 0) {
                    System.out.println("更新成功");
                    response.sendRedirect("BookUserTypeServlet");

                } else {
                    response.setHeader("refresh", "2;url=BookUserTypeServlet");
                }
            }
            //删除
            else if ("remove".equals(action)) {
                Integer id = Integer.parseInt(request.getParameter("id"));
                int count = dao.remove(id);
                if (count > 0) {
                    response.sendRedirect("BookUserTypeServlet");
                    System.out.println("删除成功");
                } else {
                    out.println("删除失败");
                    response.setHeader("refresh", "2;url=BookUserTypeServlet");
                }
            } else if ("addreader".equals(action)) {
                List<BookUserType> bookUserTypes = dao.find();
                request.setAttribute("bookUserTypes", bookUserTypes);
                request.getRequestDispatcher("back/addReader.jsp").forward(request, response);
            }
        } else {
            response.sendRedirect("back/noright.jsp");
        }
        out.flush();
        out.close();


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
