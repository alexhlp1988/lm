<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/22
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <style>
        *{ padding: 0; margin: 0;}
        li{ list-style-type: none;}
        body{ margin: 50px; font-family:\5FAE\8F6F\96C5\9ED1,'Arial';}
        a{ text-decoration: none; color:#f00;}
        h3{ background-color: #60B7DE; cursor: pointer;}
    </style>
</head>
<body bgcolor="#F2F7FB">
<h3>图书管理</h3>
<ul style="display:none">
    <li><a href="<%=request.getContextPath()%>/BookServlet" target="mainFrame">维护图书信息</a></li>
    <li><a href="<%=request.getContextPath()%>/BookTypeServlet?action=addbook" target="mainFrame">添加图书信息</a></li>
    <li><a href="<%=request.getContextPath()%>/BookTypeServlet" target="mainFrame">维护图书分类</a></li>
    <li><a href="addBookType.jsp" target="mainFrame">添加图书分类</a></li>
</ul>
<h3>读者管理</h3>
<ul style="display:none">
    <li><a href="<%=request.getContextPath()%>/BookUserServlet" target="mainFrame">维护读者信息</a></li>
    <li><a href="<%=request.getContextPath()%>/BookUserTypeServlet?action=addreader" target="mainFrame">添加读者信息</a></li>
    <li><a href="<%=request.getContextPath()%>/BookUserTypeServlet" target="mainFrame">维护读者类型</a></li>
    <li><a href="addReaderType.jsp" target="mainFrame">添加读者类型</a></li>
</ul>
<h3>借还管理</h3>
<ul style="display:none">
    <li><a href="<%=request.getContextPath()%>/back/borrowBook.jsp" target="mainFrame">图书借阅</a></li>
    <li><a href="<%=request.getContextPath()%>/back/giveBackBook.jsp" target="mainFrame">图书归还</a></li>
    <li><a href="<%=request.getContextPath()%>/ShowBorrowedBookServlet" target="mainFrame">查询借阅历史记录</a></li>
    <li><a href="<%=request.getContextPath()%>/BookWarningBackServlet" target="mainFrame">到期提醒</a></li>
</ul>
<h3>管理员信息管理</h3>
<ul style="display:none">
    <li><a href="<%=request.getContextPath()%>/ManagerServlet" target="mainFrame">维护管理员信息</a></li>
    <li><a href="addOperator.jsp" target="mainFrame">添加管理员信息</a></li>
</ul>
<script src="../js/jquery-1.7.2.min.js"></script>
<script src="../js/jquery.easing.1.3.js"></script>
<script>
    $(function(){
        $.easing.def = 'easeOutElastic';
        var oBtn = $('h3');
        oBtn.click(function(){
            $(this).next('ul').slideToggle().siblings('ul').slideUp();
        });
    });
</script>
</body>
</html>
