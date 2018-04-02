package com.lm.servlet;

import com.lm.condition.ManagerCondition;
import com.lm.dao.ManagerDao;
import com.lm.pojo.Manager;
import com.lm.util.MD5;
import com.lm.util.Pager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ManagerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        //权限验证
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
        //操作类型
        String action = request.getParameter("action");
        action = (action == null) ? "list" : action;
        System.out.println("你的操作是" + action);
        ManagerDao dao = new ManagerDao();
        //修改密码
        if ("changepwd".equals(action)){
            Integer id = Integer.parseInt(request.getParameter("id"));
            String password = request.getParameter("password");
            Manager manager = dao.find(id);
            manager.setPassword(MD5.getMD5(password));
            int count = dao.modify(manager);
            if (count > 0) {
                System.out.println("修改密码成功");
            }
            response.sendRedirect("back/main.jsp");
            return;
        }
        if (smyrights.contains("管理员操作")) {
            //查所有
            if ("list".equals(action)) {
                //分页
                String spage = request.getParameter("page");
                spage = (spage == null || "".equals(spage)) ? "1" : spage;
                Integer page = Integer.parseInt(spage);//默认第1页
                String srows = request.getParameter("rows");
                srows = (srows == null || "".equals(srows)) ? "5" : srows;
                Integer rows = Integer.parseInt(srows);//默认每页显示5行
                String sort = request.getParameter("sort");
                sort = (sort == null || "".equals(sort)) ? "id" : sort;//默认排序字段
                String order = request.getParameter("order");
                order = (order == null || "".equals(order)) ? "asc" : order;//默认排序方式
                // 条件查询
                String mname = request.getParameter("mname");

                //封装查询条件
                ManagerCondition managerCondition = new ManagerCondition();
                managerCondition.setPage(page);
                managerCondition.setRows(rows);
                managerCondition.setSort(sort);
                managerCondition.setOrder(order);
                managerCondition.setMname(mname);
                //执行分页查询
                Pager<Manager> pager = dao.find(managerCondition);
                // 把数据库的结果集放到 request 对象,jsp 迭代此结果集
                request.setAttribute("pager", pager);
                request.setAttribute("page", page);
                request.setAttribute("rows", rows);
                request.setAttribute("sort", sort);
                request.setAttribute("order", order);
                Integer pageSize = (pager.getTotal() % rows == 0) ? pager.getTotal() / rows : pager.getTotal() / rows + 1;
                request.setAttribute("pageSize", pageSize);
                // 转发到指定 jsp,显示数据
                request.getRequestDispatcher("back/showAllOperator.jsp").forward(request, response);
            } else if ("add".equals(action)) {
                String mname = request.getParameter("mname");
                Manager manager2 = dao.checkMname(mname);
                if (manager2 == null) {//没有记录则新增
                    String spassword = request.getParameter("password");
                    String password = MD5.getMD5(spassword);
                    String[] srights = request.getParameterValues("rights");
                    if (srights == null){
                        out.println("请至少选择一项权限");
                        response.setHeader("refresh", "2;url=back/addOperator.jsp");
                        return;
                    }
                    StringBuilder sb = new StringBuilder();
                    for (String r : srights) {
                        sb.append(r);
                        sb.append(",");
                    }
                    String brights = sb.toString();
                    String rights = brights.substring(0, brights.length() - 1);
//            System.out.println(rights);
                    Manager manager = new Manager();
                    manager.setMname(mname);
                    manager.setPassword(password);
                    manager.setRights(rights);
                    int count = dao.add(manager);
                    if (count > 0) {
                        System.out.println("新增管理员成功");
                    }
                    response.sendRedirect("ManagerServlet");
                } else {
                    out.println("管理员重名");
                    response.setHeader("refresh", "2;url=ManagerServlet");
                }
            } else if ("detail".equals(action)) {
                Integer id = Integer.parseInt(request.getParameter("id"));
                Manager manager = dao.find(id);
                if (manager != null) {
                    Set<String> srights = new HashSet<>();
                    String[] mrights = manager.getRights().split(",");
                    for (String s : mrights) {
                        srights.add(s);//权限分别放入set
                    }
                    if (srights.contains("图书操作")) {
                        request.setAttribute("book", "图书操作");
                    }
                    if (srights.contains("借还操作")) {
                        request.setAttribute("borrow", "借还操作");
                    }
                    if (srights.contains("读者操作")) {
                        request.setAttribute("reader", "读者操作");
                    }
                    if (srights.contains("管理员操作")) {
                        request.setAttribute("manage", "管理员操作");
                    }

                    request.setAttribute("manager", manager);
                    request.getRequestDispatcher("back/updateOperator.jsp").forward(request, response);
                } else {
                    out.println("查无此 id: " + id);
                    response.setHeader("refresh", "2;url=ManagerServlet");
                }
            } else if ("modify".equals(action)) {
                Integer id = Integer.parseInt(request.getParameter("id"));
                String mname = request.getParameter("mname");
                String[] srights = request.getParameterValues("rights");
                if (srights == null){
                    out.println("请至少选择一项权限");
                    response.setHeader("refresh", "2;url=ManagerServlet");
                    return;
                }
                StringBuilder sb = new StringBuilder();
                for (String r : srights) {
                    sb.append(r);
                    sb.append(",");
                }
                String brights = sb.toString();
                String rights = brights.substring(0, brights.length() - 1);
                Manager manager = dao.find(id);
                manager.setRights(rights);
                int count = dao.modify(manager);
                if (count > 0) {
                    System.out.println("更新成功");
                }
                response.sendRedirect("ManagerServlet");
            } else if ("delete".equals(action)) {
                Integer id = Integer.parseInt(request.getParameter("id"));
                int count = dao.remove(id);
                if (count > 0) {
                    System.out.println("删除成功");
                }
                response.sendRedirect("ManagerServlet");
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
