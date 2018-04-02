<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/24
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <script language="javascript">
        function check(form){
            if(form.bookname.value==""){
                alert("书名不能为空！");
                form.bookname.focus();return false;
            }
            if(form.author.value==""){
                alert("作者不能为空！");
                form.author.focus();return false;
            }
            if(form.publisher.value==""){
                alert("出版社不能为空！");
                form.publisher.focus();return false;
            }

            if(form.price.value==""){
                alert("价格不能为空！");
                form.price.focus();return false;
            }

            var temp = document.getElementById("price");
            //对价格的验证
            var priceStr = /^([1-9]+[0-9]*)+\.+[0-9]{1,2}$/;
            if(!priceStr.test(temp.value))
            {
                alert('提示\n\n价格的格式为：\n89.5\n89.00！');
                temp.focus();
                return false;
            }
        }
    </script>
    <title>更新图书信息</title>
    <link href="<%=request.getContextPath()%>/css/StyleSheet.css" rel="stylesheet" type="text/css" />
</head>
<body onload="getTypes()">
<form id="form" name="form" method="post" action="BookServlet">
    <input type="hidden" name="id" value="${book.id}" />
    <input type="hidden" name="action" value="modify" />
    <table width="381" border="0" cellpadding="0" cellspacing="0"
           align="center">
        <tr>
            <td colspan="2" class="tb_addbookBgImage">
                修改图书信息
            </td>
        </tr>
        <tr>
            <td class="tb_addbook" width="98">
                图书名称
            </td>
            <td width="267" class="tb_addbookRight">
                <label>
                    <input type="text" name="name" value="${book.name}" />
                </label>
            </td>
        </tr>
        <tr>
            <td class="tb_addbook">作者</td>
            <td class="tb_addbookRight">
                <label>
                    <input type="text" name="author" value="${book.author}" />
                </label>
            </td>
        </tr>
        <tr>
            <td class="tb_addbook">出版社</td>
            <td class="tb_addbookRight">
                <label>
                    <input type="text" name="publisher" value="${book.publisher}" />
                </label>
            </td>
        </tr>
        <tr>
            <td class="tb_addbook">价格</td>
            <td class="tb_addbookRight">
                <label>
                    <input type="text" name="price" value="${book.price}" />
                </label>
            </td>
        </tr>
        <tr>
            <td class="tb_addbook">类型</td>
            <td class="tb_addbookRight">
                <select name="type">
                    <c:forEach var="bt" items="${bookTypes}">
                        <option ${book.book_type==bt.typename?'selected':''}>${bt.typename}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td colspan="2" class="tb_addbookall">
                <label>
                    <div align="center">
                        <input class="input_bg" type="submit" name="Submit" value="提交"
                               onclick="return check(form)" />
                        &nbsp;&nbsp;

                        <input class="input_bg" type="reset" name="reset" value="重置" />
                    </div>
                </label>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
