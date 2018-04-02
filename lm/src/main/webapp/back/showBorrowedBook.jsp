<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/26 0026
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link href="<%=request.getContextPath()%>/css/StyleSheet.css" rel="stylesheet" type="text/css"/>
    <title>借阅历史记录</title>
</head>
<body>
<table width=800 border="0" cellpadding="0" cellspacing="0"
       align="center">
    <tr>
        <td colspan="11" class="tb_addbookBgImage">借阅历史记录</td>
    </tr>
    <tr>
        <td class="tb_sabookBorder">图书编号</td>
        <td class="tb_sabookBorder">图书名称</td>
        <td class="tb_sabookBorder">读者帐号</td>
        <td class="tb_sabookBorder">读者真实姓名</td>
        <td class="tb_sabookBorder">借书证号</td>
        <td class="tb_sabookBorder">借书日期</td>
        <td class="tb_sabookBorder">到期时间</td>
        <td class="tb_sabookBorder">操作人</td>
        <td class="tb_sabookBorder">归还情况</td>
        <td class="tb_sabookBorder">还书日期</td>
        <td colspan="2" class="tb_sabookBorder">操作</td>
    </tr>
    <c:forEach var="showbook" items="${msg}">
        <tr>
            <td class="tb_sabookMain">${showbook.isbn}</td>
            <td class="tb_sabookMain">${showbook.bookname}</td>
            <td class="tb_sabookMain">${showbook.account}</td>
            <td class="tb_sabookMain">${showbook.username}</td>
            <td class="tb_sabookMain">${showbook.library_card}</td>
            <td class="tb_sabookMain"><fmt:formatDate value="${showbook.borrow_date}" pattern="yyyy-MM-dd"/></td>
            <td class="tb_sabookMain"><fmt:formatDate value="${showbook.expire_date}" pattern="yyyy-MM-dd"/></td>
            <td class="tb_sabookMain">${showbook.manager}</td>
            <td class="tb_sabookMain">
                    ${showbook.is_back==0?'未借出':''}
                    ${showbook.is_back==1?'已借出':''}
                    ${showbook.is_back==2?'审核借书中':''}
                    ${showbook.is_back==3?'审核还书中':''}
                    ${showbook.is_back==4?'已归还':''}
            </td>
            <td class="tb_sabookMain"><fmt:formatDate value="${showbook.back_date}" pattern="yyyy-MM-dd"/></td>
            <td>
                <button type="button" onclick="toborrow(${showbook.isbn},${showbook.library_card})">借出</button>
            </td>
            <td>
                <button type="button" onclick="toreturn(${showbook.isbn},${showbook.library_card})">归还</button>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="11">
        </td>
    </tr>

</table>
<script>
    function toborrow(isbn,lc) {
        location.href = "BookBorrowBookUserServlet?action=borrow&barcode=" + isbn+"&identiCode="+lc;
    }

    function toreturn(isbn,lc) {
        location.href = "BookBorrowBookUserServlet?action=return&barcode=" + isbn+"&identiCode="+lc;
    }
</script>
</body>

</html>
