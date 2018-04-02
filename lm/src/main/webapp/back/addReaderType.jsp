<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/22
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>

<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>增加读者类型</title>
    <link href="../css/StyleSheet.css" rel="stylesheet" type="text/css" />
    <script language="javascript">
        function check(form){
            if(form.name.value==""){
                alert("类型名称不能为空!");
                form.name.focus();
                return false;
            }
            if(form.quantity.value==""){
                alert("可借数量不能为空！");
                form.name.focus();
                return false;
            }

            var temp = document.getElementById("quantity");
            //对数量的验证
            var quantityStr = /^[1-9]+[0-9]*$/;
            if(!quantityStr.test(temp.value)){
                alert('提示\n\n请输入正确的可借数量');
                temp.focus();
                return false;
            }
        }
    </script>
</head>

<body>
<form id="form" name="form" method="post" action="../BookUserTypeServlet">
    <input type="hidden" name="action" value="add">
    <table width="423" border="0" cellpadding="0" cellspacing="0"
           align="center">
        <tr>
            <td colspan="2" height="25" class="tb_addbookBgImage">
                增加读者类型
            </td>
        </tr>
        <tr>
            <td width="121" class="tb_addbook">
                类型名称
            </td>
            <td width="186" class="tb_addbookRight">
                <label>
                    <input type="text" name="name" />
                </label>
            </td>
        </tr>
        <tr>
            <td class="tb_addbook">
                可借数量
            </td>
            <td class="tb_addbookRight">
                <label>
                    <input type="text" name="quantity" />
                </label>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center" class="tb_addbookall">
                <label>
                    <input class="input_bg" type="submit" name="submit" value="提交"
                           onclick="return check(form)" />
                    &nbsp;&nbsp;
                </label>
                <label>
                    <input class="input_bg" type="reset" name="reset" value="重置" />
                </label>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
