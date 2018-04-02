package com.lm.servlet;

import com.lm.dao.BookUserDao;
import com.lm.dao.BookUserTypeDao;
import com.lm.pojo.BookUser;
import com.lm.pojo.BookUserType;
import com.lm.util.MD5;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
//需做分页
@WebServlet(name = "BookUserServlet")
public class BookUserServlet extends HttpServlet {
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

        if (smyrights.contains("读者操作")) {
            String action = request.getParameter("action");
            action = (action == null) ? "list" : action;
            System.out.println("您的操作是：" + action);
            BookUserDao dao = new BookUserDao();

            if ("list".equals(action)) {
                //查询所有
                List<BookUser> bookUsers = dao.find();
                request.setAttribute("bookUsers", bookUsers);
                request.getRequestDispatcher("back/showAllReader.jsp").forward(request, response);

            } else if ("add".equals(action)) {
                String id = request.getParameter("id");
                String account = request.getParameter("name");
                String lcard = request.getParameter("lcard");
                //验证是否重复
                if (dao.checkAccount("name") != null) {
                    out.println("用户名重复不能添加");
                    response.setHeader("refresh", "2;url=BookUserServlet");
                    return;
                } else if (dao.checkLCard(lcard) != null) {
                    out.println("借书证号重复不能添加");
                    response.setHeader("refresh", "2;url=BookUserServlet");
                    return;
                } else {
                    String password = request.getParameter("password");
                    String name = request.getParameter("realName");
                    String sex = request.getParameter("sex");
                    String cardtype = request.getParameter("papertype");
                    String card_id = request.getParameter("paperNo");

                    String phone = request.getParameter("tel");
                    String email = request.getParameter("email");
                    String usertype = request.getParameter("type");
                    String back_up = request.getParameter("description");
                    String manager = (String) session.getAttribute("mname");
                    //封装表单数据到对象
                    BookUser bookUser = new BookUser();
                    bookUser.setAccount(account);
                    bookUser.setPassword(MD5.getMD5(password));
                    bookUser.setName(name);
                    bookUser.setSex(sex);
                    bookUser.setCardtype(cardtype);
                    bookUser.setCard_id(card_id);
                    bookUser.setLibrary_card(lcard);
                    bookUser.setPhone(phone);
                    bookUser.setEmail(email);
                    bookUser.setUsertype(usertype);
                    bookUser.setBack_up(back_up);
                    bookUser.setReg_date(new Date());
                    bookUser.setManager(manager);

                    int count = 0;
                    count = dao.add(bookUser);
                    if (count > 0) {

                        System.out.println("增加成功");
                        response.sendRedirect("BookUserServlet");
                    }

                }
                //修改
            } else if ("modify".equals(action)) {
                String id = request.getParameter("id");
                //  String account = request.getParameter("account");
                String name = request.getParameter("realName");
                String sex = request.getParameter("sex");
                String cardtype = request.getParameter("papertype");
                System.out.println(cardtype);
                String card_id = request.getParameter("paperNo");
                String usertype = request.getParameter("type");

                BookUser bookUser = dao.findById(Integer.parseInt(id));

                //bookUser.setId(Integer.parseInt(id));
                //   bookUser.setAccount(account);
                bookUser.setName(name);
                bookUser.setSex(sex);
                bookUser.setCardtype(cardtype);
                bookUser.setCard_id(card_id);
                bookUser.setUsertype(usertype);

                int count = dao.modify(bookUser);
                if (count > 0) {
                    response.sendRedirect("BookUserServlet");
                    System.out.println("操作成功");
                } else {
                    //增加失败
                    out.println("保存失败");
                    response.setHeader("refresh", "2;url=BookUserServlet");
                }
//根据id查询
            } else if ("findById".equals(action)) {
                BookUserTypeDao utdao = new BookUserTypeDao();
                Integer id = Integer.parseInt(request.getParameter("id"));
                BookUser bookUser = dao.findById(id);
                if (bookUser != null) {
                    List<BookUserType> bookUserTypes = utdao.find();
                    request.setAttribute("bookUserTypes", bookUserTypes);
                    request.setAttribute("bookUser", bookUser);
                    request.getRequestDispatcher("back/updateReader.jsp").forward(request, response);
                }
            } else if ("remove".equals(action)) {
                //删除
                Integer id = Integer.parseInt(request.getParameter("id"));
                int bcount = dao.delBorrow(id);
                if (bcount>0){
                    System.out.println("级联删除成功");
                }
                int count = dao.remove(id);
                if (count > 0) {
                    response.sendRedirect("BookUserServlet");
                } else {
                    //保存失败
                    out.println("删除失败");
                    response.setHeader("refresh", "2;url=BookUserServlet");
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
