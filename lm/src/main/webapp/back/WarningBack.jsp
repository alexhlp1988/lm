<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/29 0029
  Time: 12:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link href="<%=request.getContextPath()%>/css/StyleSheet.css" rel="stylesheet" type="text/css" />
    <title>快要到期图书</title>
</head>

<body>
<table width="1000" border="0" cellpadding="0" cellspacing="0"
       align="center">
    <tr>
        <td colspan="11" class="tb_addbookBgImage">
            <div align="center">快要到期图书列表</div>
        </td>
    </tr>
    <tr>
        <td class="tb_sabookBorder">图书编码</td>
        <td class="tb_sabookBorder">书名</td>
        <td class="tb_sabookBorder">读者名称</td>
        <td class="tb_sabookBorder">读者证件类型</td>
        <td class="tb_sabookBorder">读者证件号</td>
        <td class="tb_sabookBorder">读者真实姓名</td>
        <td class="tb_sabookBorder">读者Email</td>
        <td class="tb_sabookBorder">读者电话</td>
        <td class="tb_sabookBorder">读者类型</td>
        <td class="tb_sabookBorder">借书时间</td>
        <td class="tb_sabookBorder">到期时间</td>
    </tr>
<c:forEach var="mm" items="${books}">
    <tr>
        <td class="tb_sabookMain">${mm.isbn}</td>
        <td class="tb_sabookMain">${mm.bookname}</td>
        <td class="tb_sabookMain">${mm.account}</td>
        <td class="tb_sabookMain">${mm.cardtype}</td>
        <td class="tb_sabookMain">${mm.card_id}</td>
        <td class="tb_sabookMain">${mm.username}</td>
        <td class="tb_sabookMain">${mm.email}</td>
        <td class="tb_sabookMain">${mm.phone}</td>
        <td class="tb_sabookMain">${mm.usertype}</td>
        <td class="tb_sabookMain"><fmt:formatDate value="${mm.borrow_date}" pattern="yyyy-MM-dd"/></td>
        <td class="tb_sabookMain"><fmt:formatDate value="${mm.expire_date}" pattern="yyyy-MM-dd"/></td>
    </tr>
</c:forEach>
    <tr>
        <td colspan="11">
        </td>
    </tr>
</table>

</body>

</html>