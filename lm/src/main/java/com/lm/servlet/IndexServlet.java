package com.lm.servlet;

import com.lm.dao.ManagerDao;
import com.lm.pojo.Manager;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        // 登录标记
        boolean flag = false;
        HttpSession session = request.getSession();
        // 1.获取客户端的所有的 cookie
        Cookie[] cookies = request.getCookies();
        ManagerDao dao = new ManagerDao();
        if (cookies != null) {
            if(session.getAttribute("mname") == null) {//未登录才从cookie中取值
                for (Cookie cookie : cookies) {
                    // 2.获取当前网站的 cookie
                    if ("mname".equals(cookie.getName()) && cookie.getValue() != null) {
                        System.out.println("已登录");
                        //根据用户名获得manager
                        Manager manager = dao.checkMname(cookie.getValue());
                        //权限存储到session中
                        session.setAttribute("rights", manager.getRights());
                        //把用户ID存到session
                        session.setAttribute("id", manager.getId());
                        // 2.1 已登录则获取用户名存储到 session
                        session.setAttribute("mname", cookie.getValue());
                        // 2.2 更改登录标记
                        flag = true;
                        break;
                    }
                }
            } else {
                flag = true;
            }
        }
        // 3.根据 flag 重定向
        String url = "";
        if (flag) {
            url = "back/index.jsp";
        } else {
            url = "back/operatorLogin.jsp";
        }
        response.sendRedirect(url);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
