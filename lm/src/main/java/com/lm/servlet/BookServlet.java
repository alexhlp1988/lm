package com.lm.servlet;

import com.lm.condition.Condition;
import com.lm.dao.BookDao;
import com.lm.dao.BookTypeDao;
import com.lm.pojo.Book;
import com.lm.pojo.BookType;
import com.lm.util.Pager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
//需做分页
@WebServlet(name = "BookServlet")
public class BookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //请求时避免乱码，使用过滤器
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

            //一个业务线用一个servlet；通过action描述操作
            String action = request.getParameter("action");
            //默认执行查询操作
            action = (action == null) ? "list" : action;
            System.out.println("你的操作是：" + action);

            BookDao dao = new BookDao();
            if ("list".equals(action)) {
                //查询所有
                List<Book> books = dao.find();
//                System.out.println(books.size() + "----------------");
                request.setAttribute("books", books);

                String spage = request.getParameter("page");
                spage = (spage == null || "".equals(spage)) ? "1" : spage;
                Integer page = Integer.parseInt(spage);//默认第一页
                String srows = request.getParameter("rows");
                srows = (srows == null || "".equals(srows)) ? "5" : srows;
                Integer rows = Integer.parseInt(srows);//默认每页显示5行
                String sort = request.getParameter("sort");
                sort = (sort == null || "".equals(sort)) ? "book" : sort;//默认排序字段
                String order = request.getParameter("order");
                order = (order == null || "".equals(order)) ? "asc" : order;//默认排序方式

                //封装查询条件
                Condition condition = new Condition();
                condition.setPage(page);
                condition.setRows(rows);
                condition.setSort(sort);
                condition.setOrder(order);
                //执行分页查询
                //
                //
                request.getRequestDispatcher("back/showAllBook.jsp").forward(request, response);
                //增加
            } else if ("add".equals(action)) {

                //接收表单数据，并转换数据类型
                String id = request.getParameter("id");
                String isbn = request.getParameter("isbn");
                if(isbn.length()!=13) {
                    out.println("isbn必须是13位数字");
                    response.setHeader("refresh", "2;url=BookServlet");
                    return;
                }
                Book cbook = dao.checkIsbn(isbn);
                if (cbook!=null) {
                    out.println("isbn必须是唯一的");
                    response.setHeader("refresh", "2;url=BookServlet");
                    return;
                }
                String name = request.getParameter("bookname");
                String author = request.getParameter("author");
                String publisher = request.getParameter("publisher");
                String price = request.getParameter("price");
                //转换数据时间的类型
//        String signdate = request.getParameter("sign_date");
//            Date sign_date = new Date();
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            try {
//                sign_date = sdf.parse(signdate);
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
                String manager = (String) session.getAttribute("mname");
                String amount = request.getParameter("num");
                String book_type = request.getParameter("type");

                //封装表单数据到对象
                Book book = new Book();
                //       book.setId(Integer.parseInt(id));
                book.setIsbn(isbn);
                book.setName(name);
                book.setAuthor(author);
                book.setPublisher(publisher);
                book.setPrice(Double.parseDouble(price));
                //   book.setSign_date(sign_date);
                book.setManager(manager);
                book.setAmount(Integer.parseInt(amount));
                book.setBook_type(book_type);

                int count = 0;
                count = dao.add(book);
                if (count > 0) {
                    //重定向查询，及时显示新增成功后的数据
                    System.out.println("成功");
                    response.sendRedirect("BookServlet");
                } else {
                    //增加失败
                    out.println("保存失败");
                    response.setHeader("refresh", "2;url=BookServlet");
                }
                //修改
            } else if ("modify".equals(action)) {

                String id = request.getParameter("id");
                String name = request.getParameter("name");
                String author = request.getParameter("author");
                String publisher = request.getParameter("publisher");
                String price = request.getParameter("price");
                String book_type = request.getParameter("type");

                Book book = dao.detail(Integer.parseInt(id));

                book.setId(Integer.parseInt(id));
                book.setName(name);
                book.setAuthor(author);
                book.setPublisher(publisher);
                book.setPrice(Double.parseDouble(price));
                book.setBook_type(book_type);

                int count = dao.modify(book);
                if (count > 0) {
                    response.sendRedirect("BookServlet");
                    System.out.println("操作成功");
                } else {
                    //增加失败
                    out.println("保存失败");
                    response.setHeader("refresh", "2;url=BookServlet");
                }

                //根据id查询
            } else if ("detail".equals(action)) {
                BookTypeDao btdao = new BookTypeDao();
                Integer id = Integer.parseInt(request.getParameter("id"));
                Book book = dao.detail(id);
                if (book != null) {
                    List<BookType> bookTypes = btdao.find();
                    System.out.println(bookTypes.size() + "------");
                    request.setAttribute("bookTypes", bookTypes);
                    request.setAttribute("book", book);
                    request.getRequestDispatcher("back/updateBook.jsp").forward(request, response);
                }
            } else if ("remove".equals(action)) {
                //删除
                Integer id = Integer.parseInt(request.getParameter("id"));
                int bcount = dao.delBorrow(id);
                if (bcount>0) {
                    System.out.println("级联删除成功");
                }
                int count = dao.remove(id);
                if (count > 0) {
                    response.sendRedirect("BookServlet");
                } else {
                    //保存失败
                    out.println("删除失败");
                    response.setHeader("refresh", "2;url=BookServlet");
                }

            } else if ("addamount".equals(action)) {
                Integer id = Integer.parseInt(request.getParameter("id"));
                Integer num = Integer.parseInt(request.getParameter("num"));
                Book book = dao.detail(id);
                book.setAmount(book.getAmount() + num);
                int count = dao.modify(book);
                if (count > 0) {
                    System.out.println("操作成功");
                    response.sendRedirect("BookServlet");

                } else {
                    //增加失败
                    out.println("保存失败");
                    response.setHeader("refresh", "2;url=BookServlet");
                }
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
