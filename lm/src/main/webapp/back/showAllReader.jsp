<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/22
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>查看读者信息</title>
    <link href="<%=request.getContextPath()%>/css/StyleSheet.css" rel="stylesheet" type="text/css" />
</head>

<body>

<table width="1000" height="100" border="0" cellpadding="0"
       cellspacing="0" align="center">
    <tr>
        <td colspan="13" class="tb_showallbook">
            <div align="center">
                读者信息列表
            </div>
        </td>
    </tr>
    <tr>
        <td class="tb_sabookBorder">用户帐号</td>
        <td class="tb_sabookBorder">读者类型</td>
        <td class="tb_sabookBorder">真实姓名</td>
        <td class="tb_sabookBorder">性别</td>
        <td class="tb_sabookBorder">借书证编号</td>
        <td class="tb_sabookBorder">证件类型</td>
        <td class="tb_sabookBorder">证件号码</td>
        <td class="tb_sabookBorder">电话</td>
        <td class="tb_sabookBorder">电子邮箱</td>
        <td class="tb_sabookBorder">注册时间</td>
        <td class="tb_sabookBorder">备注</td>
        <td class="tb_sabookBorder">操作</td>

        <c:forEach var="bookUser" items="${bookUsers}">
    <tr>


        <td class="tb_sabookMain">${bookUser.account}</td>
        <td class="tb_sabookMain">${bookUser.usertype}</td>
        <td class="tb_sabookMain">${bookUser.name}</td>
        <td class="tb_sabookMain">${bookUser.sex}</td>
        <td class="tb_sabookMain">${bookUser.library_card}</td>
        <td class="tb_sabookMain">${bookUser.cardtype}</td>
        <td class="tb_sabookMain">${bookUser.card_id}</td>
        <td class="tb_sabookMain">${bookUser.phone}</td>
        <td class="tb_sabookMain">${bookUser.email}</td>
        <td class="tb_sabookMain"><fmt:formatDate value="${bookUser.reg_date}" pattern="yyyy-MM-dd"/></td>
        <td class="tb_sabookMain">${bookUser.back_up}</td>
        <td class="tb_sabookMain">
            <a href="BookUserServlet?action=findById&id=${bookUser.id}">编辑</a>
            <a href="BookUserServlet?action=remove&id=${bookUser.id}"onclick="return confirm('是否确认删除 ${bookUser.name} ?')">删除</a>
        </td>
    </tr>
    <</c:forEach>





    <tr>
        <td colspan="13">

            <a href="showAllReader.html">第1页</a>

        </td>
    </tr>
</table>


</body>
</html>