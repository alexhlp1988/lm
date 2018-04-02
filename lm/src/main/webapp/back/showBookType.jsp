<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/22
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>显示所有的图书类型</title>
    <link href="<%=request.getContextPath()%>/css/StyleSheet.css" rel="stylesheet" type="text/css" />
</head>

<body>
<center>
    <h2></h2>
</center>
<table width="558" border="0" cellpadding="0" cellspacing="0"
       align="center">
    <tr>
        <td colspan="3" class="tb_showallbook">
            <div align="center">
                图书类型
            </div>
        </td>
    </tr>
    <tr>
        <td class="tb_sabookBorder">
            编号
        </td>
        <td class="tb_sabookBorder">
            类型名称
        </td>
        <td class="tb_sabookBorder">
            操作
        </td>
    </tr>
<c:forEach var="bookType" items="${bookTypes}">
    <tr>
        <td height="28" class="tb_sabookMain">${bookType.id}</td>
        <td class="tb_sabookMain">${bookType.typename}</td>
        <td class="tb_sabookMain">
            <a href="BookTypeServlet?action=findById&id=${bookType.id}">编辑</a>
            <a href="BookTypeServlet?action=remove&id=${bookType.id}"onclick="return confirm('是否确认删除 ${book.name} ?')">删除</a>
        </td>
    </tr>
</c:forEach>


</table>
</body>
</html>

