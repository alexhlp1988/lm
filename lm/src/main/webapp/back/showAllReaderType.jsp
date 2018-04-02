<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/22
  Time: 16:11
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
    <title>显示读者类型信息</title>
    <link href="<%=request.getContextPath()%>/css/StyleSheet.css" rel="stylesheet" type="text/css" />
</head>

<body>
<center>
    <h2></h2>
</center>
<form id="form1" name="form1" method="post" action="../BoookUserTypeServlet">
    <table width="500" height="110" border="0" cellpadding="0"
           cellspacing="0" align="center">
        <tr>
            <td colspan="3" class="tb_showallbook">
                <div align="center">
                    显示所有的读者类型
                </div>
            </td>
        </tr>
        <tr>
            <td class="tb_sabookBorder" width="71">
                类型名称
            </td>
            <td class="tb_sabookBorder">
                可借图书数量
            </td>
            <td class="tb_sabookBorder" width="61">
                操作
            </td>
        </tr>
        <c:forEach var="bookUserType" items="${bookUserTypes}">
        <tr>
            <td class="tb_sabookMain">${bookUserType.typename}</td>
            <td class="tb_sabookMain">${bookUserType.book_count}</td>
            <td class="tb_sabookMain">
                <a href="BookUserTypeServlet?action=findById&id=${bookUserType.id}">编辑</a>
                <a href="BookUserTypeServlet?action=remove&id=${bookUserType.id}"onclick="return confirm('是否确认删除 ${bookUserType.typename} ?')">删除</a>
            </td>
        </tr>
        </c:forEach>


    </table>
</form>
</body>
</html>