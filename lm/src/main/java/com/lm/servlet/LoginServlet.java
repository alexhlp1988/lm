package com.lm.servlet;

import com.lm.dao.ManagerDao;
import com.lm.pojo.Manager;
import com.lm.util.MD5;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        // 获取操作 (登录 | 注销)
        String action = request.getParameter("action");
        ManagerDao dao = new ManagerDao();
        if ("login".equals(action)) { //登录
            String checkcode = request.getParameter("checkcode");
            String randomcode = (String) session.getAttribute("Rand");
            if (checkcode.equals(randomcode)) {//验证码正确，验证帐号密码
                String mname = request.getParameter("mname");
                String spassword = request.getParameter("password");
                String password = MD5.getMD5(spassword);
                Manager manager = dao.checkPwd(mname, password);
                if (manager!=null) {//登录成功
                    System.out.println("登录成功");

                    //把用户名存储到 session
                    session.setAttribute("mname", mname);
                    //把用户ID存到session
                    session.setAttribute("id",manager.getId());

                    //权限存储到session中
                    session.setAttribute("rights", manager.getRights());
                    //若勾选 记住我 则把用户名存储到 cookie
                    String rememberme = request.getParameter("rememberme");
                    if (rememberme != null) {
                        System.out.println("勾选,记录 cookie");
                        Integer expiry = Integer.parseInt(request.getParameter("expiry"));
                        Cookie cookie = new Cookie("mname", mname);
                        cookie.setMaxAge(expiry);
                        response.addCookie(cookie);
                    } else {
                        System.out.println("未勾选,不记录 cookie");
                    }
                    request.getRequestDispatcher("/back/index.jsp").forward(request, response);
                } else {
                    out.println("密码错误...");
                    response.setHeader("refresh", "3,back/operatorLogin.jsp");
                }
            } else {
                out.println("验证码不匹配...");
                response.setHeader("refresh", "3,back/operatorLogin.jsp");
            }
        } else if ("logout".equals(action)) {
            if (session.getAttribute("mname") != null) {
                session.removeAttribute("mname");
                if (session.getAttribute("rights") != null) {
                    session.removeAttribute("rights");
                }
                session.invalidate();
            }
            response.sendRedirect("back/operatorLogin.jsp");
        }
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
