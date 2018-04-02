<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/22
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>查看所有的图书信息</title>
    <link href="<%=request.getContextPath()%>/css/StyleSheet.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" language="JavaScript">
        function checkNum(numValue){
            //对数量的验证
            var numStr = /^[1-9]+[0-9]*$/;
            if(!numStr.test(numValue.value)){
                alert('提示\n\n请输入正确的数量');
                numValue.focus();
                return false;
            }
        }
    </script>
</head>
<body>
<table width="910" border="0" cellpadding="0" cellspacing="0"
       align="center">
    <tr>
        <td colspan="10" class="tb_showallbook">
            <div align="center">
                图书信息列表
            </div>
        </td>
    </tr>
    <tr>
        <td class="tb_sabookBorder">
            ISBN
        </td>
        <td class="tb_sabookBorder">
            图书名称
        </td>
        <td class="tb_sabookBorder">
            作者
        </td>
        <td class="tb_sabookBorder">
            出版社
        </td>
        <td class="tb_sabookBorder">
            价格（元）
        </td>
        <td class="tb_sabookBorder">
            入馆时间
        </td>
        <td class="tb_sabookBorder">
            图书类型
        </td>
        <td class="tb_sabookBorder">
            管理员
        </td>
        <td class="tb_sabookBorder">
            操作
        </td>
        <td class="tb_sabookBorder">
            添加数量
        </td>
    </tr>
    <c:forEach var="book" items="${books}">
    <tr>
        <td class="tb_sabookMain">${book.isbn}</td>
        <td class="tb_sabookMain">${book.name}</td>
        <td class="tb_sabookMain">${book.author}</td>
        <td class="tb_sabookMain">${book.publisher}</td>
        <td class="tb_sabookMain">${book.price}</td>
        <td class="tb_sabookMain"><fmt:formatDate value="${book.sign_date}" pattern="yyyy-MM-dd"/></td>
        <td class="tb_sabookMain">${book.book_type}</td>
        <td class="tb_sabookMain">${book.manager}</td>
        <td class="tb_sabookMain">
            <a href="BookServlet?action=detail&id=${book.id}">编辑</a>
            <a href="BookServlet?action=remove&id=${book.id}"onclick="return confirm('是否确认删除 ${book.name} ?')">删除</a>
        </td>
        <td class="tb_sabookMain">
            <form action="<%=request.getContextPath()%>/BookServlet"
                     method="post" onsubmit="return checkNum(this.num);">
                <input type="hidden" name="action" value="addamount">
                <input type="hidden" name="id" value="${book.id}">
                <input type="text" name="num" required size="4" />
                <input type="submit" name="nsubmit" value="添加" />
            </form>
        </td>
    </tr>
    </c:forEach>


    <tr>
        <td colspan="10">
        </td>
    </tr>
</table>
</body>
</html>

</body>
</html>
