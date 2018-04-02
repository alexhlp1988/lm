<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/22
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script type="text/javascript" language="JavaScript">

        function check(form){
            if(form.isbn.value.length!=13){
                alert("ISBN必须为13位！");
                form.isbn.focus();return false;
            }
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


            if(form.num.value<=0){
                alert("数量必需大于0！");
                form.num.focus();return false;
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

            var temp = document.getElementById("num");
            //对数量的验证
            var numStr = /^[1-9]+[0-9]*$/;
            if(!numStr.test(temp.value))
            {
                alert('提示\n\n请输入正确的数量');
                temp.focus();
                return false;
            }

        }
    </script>
    <title>增加图书</title>
    <link href="<%=request.getContextPath()%>/css/StyleSheet.css" rel="stylesheet" type="text/css" />

</head>

<body onload="getTypes();">
<form id="form" name="form" method="post"
      action="<%=request.getContextPath()%>/BookServlet">
    <input type="hidden" name="action" value="add">
    <table width="371" border="0" height="300" cellpadding="0"
           cellspacing="0" align="center">
        <tr>
            <td colspan="2" class="tb_addbookBgImage">
                增加图书
            </td>
        </tr>
        <tr>
            <td class="tb_addbook" width="98">
                图书名称*
            </td>
            <td class="tb_addbookRight" width="267">
                <label>
                    <input type="text" name="bookname" />
                </label>
            </td>
        </tr>
        <tr>
            <td class="tb_addbook" width="98">
                isbn*
            </td>
            <td class="tb_addbookRight" width="267">
                <label>
                    <input type="text" name="isbn" />
                </label>
            </td>
        </tr>
        <tr>
            <td class="tb_addbook">
                作者*
            </td>
            <td class="tb_addbookRight">
                <label>
                    <input type="text" name="author" />
                </label>
            </td>
        </tr>
        <tr>
            <td class="tb_addbook">
                出版社*
            </td>
            <td class="tb_addbookRight">
                <label>
                    <input type="text" name="publisher" />
                </label>
            </td>
        </tr>
        <tr>
            <td class="tb_addbook">
                价格*
            </td>
            <td class="tb_addbookRight">
                <label>
                    <input type="text" name="price" />
                </label>
            </td>
        </tr>
        <tr>
            <td class="tb_addbook">
                类型*
            </td>
            <td class="tb_addbookRight">
                <label>
                    <select name="type">
                        <c:forEach var="bt" items="${requestScope.bookTypes}">
                        <option>${bt.typename}</option>
                        </c:forEach>
                    </select>
                </label>
            </td>
        </tr>
        <tr>
            <td class="tb_addbook">
                数量*
            </td>
            <td class="tb_addbookRight">
                <label>
                    <input type="text" name="num" />
                </label>
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