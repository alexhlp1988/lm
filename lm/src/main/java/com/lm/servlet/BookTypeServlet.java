package com.lm.servlet;

import com.lm.dao.BookTypeDao;
import com.lm.pojo.BookType;

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

@WebServlet(name = "BookTypeServlet")
public class BookTypeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String myrights = (String) session.getAttribute("rights");
        if (myrights==null){//未登录时权限为null
            response.sendRedirect("back/noright.jsp");
            return;
        }
        Set<String> smyrights = new HashSet<>();
        String[] mmyrights = myrights.split(",");
        for (String s : mmyrights) {
            smyrights.add(s);//权限分别放入set
        }

        if (smyrights.contains("图书操作")) {
            String action = request.getParameter("action");
            action = (action == null) ? "list" : action;//默认执行查询操作
            System.out.println("您的操作是：" + action);

            BookTypeDao dao = new BookTypeDao();

            if ("list".equals(action)) {
                //查询所有
                List<BookType> bookTypes = dao.find();
                System.out.println(bookTypes.size() + "------");
                request.setAttribute("bookTypes", bookTypes);
                request.getRequestDispatcher("back/showBookType.jsp").forward(request, response);
            } else if ("add".equals(action)) {
                String id = request.getParameter("id");
                String typename = request.getParameter("name");
                //封装表单数据到对象
                BookType bookType = new BookType();
                bookType.setTypename(typename);

                int count = 0;
                count = dao.add(bookType);
                if (count > 0) {
                    response.sendRedirect("BookTypeServlet");
                    System.out.println("增加成功");
                } else {
                    //增加失败
                    out.println("失败");
                    response.setHeader("refresh", "2;url=BookTypeServlet");

                }
            }
            //修改
            else if ("modify".equals(action)) {
                String id = request.getParameter("id");
                String typename = request.getParameter("name");

                BookType bookType = dao.findById(Integer.parseInt(id));

                bookType.setId(Integer.parseInt(id));
                bookType.setTypename(typename);

                int count = 0;
                count = dao.modify(bookType);
                if (count > 0) {
                    response.sendRedirect("BookTypeServlet");
                    System.out.println("更新成功");
                } else {
                    out.println("更新失败");
                    response.setHeader("refresh", "2;url=BookTypeServlet");
                }
            }
            //删除
            else if ("remove".equals(action)) {
                //增加判断，有书的图书种类不能删除
                Integer id = Integer.parseInt(request.getParameter("id"));
                BookType bookType = dao.findById(id);
                int bookcount = dao.checkBookCount(bookType.getTypename());
                if (bookcount > 0) {
                    out.println("删除失败，不能删除有书的类别");
                    response.setHeader("refresh", "2;url=BookTypeServlet");
                    return;
                }
                int count = dao.remove(id);
                if (count > 0) {
                    response.sendRedirect("BookTypeServlet");
                    System.out.println("删除成功");
                } else {
                    out.println("删除失败");
                    response.setHeader("refresh", "2;url=BookTypeServlet");
                }

            } else if ("findById".equals(action)) {
                Integer id = Integer.parseInt(request.getParameter("id"));
                BookType bookType = dao.findById(id);
                if (bookType != null) {
                    request.setAttribute("bookType", bookType);
                    request.getRequestDispatcher("back/updateBookType.jsp").forward(request, response);
                }
            } else if ("addbook".equals(action)) {
                //查询所有
                List<BookType> bookTypes = dao.find();
                System.out.println(bookTypes.size() + "------");
                request.setAttribute("bookTypes", bookTypes);
                request.getRequestDispatcher("back/addBook.jsp").forward(request, response);
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
