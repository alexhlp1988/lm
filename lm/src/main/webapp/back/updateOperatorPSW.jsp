<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/23
  Time: 15:45
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
    <script language="javascript">
        function check(form){
            if (form.password.value==""){
                alert("请输入管理员密码!");form.password.focus();return false;
            }
            if (form.password.value!=form.password2.value){
                alert("两次输入的密码不一致!");form.password.focus();return false;
            }
        }
    </script>
    <title>更改密码</title>
    <link href="<%=request.getContextPath()%>/css/StyleSheet.css" rel="stylesheet" type="text/css" />
</head>

<body>
<hr />
<form id="form" name="form1" method="post"	action="<%=request.getContextPath()%>/ManagerServlet">
    <input type="hidden" name="id" value="${sessionScope.id}" />
    <input type="hidden" name="action" value="changepwd">
    <table width="355" border="0" cellpadding="0" cellspacing="0"
           align="center">
        <tr>
            <td colspan="2" class="tb_addbookBgImage">
                更改密码
            </td>
        </tr>
        <tr>
            <td class="tb_addbook">
                管理员名称
            </td>
            <td class="tb_addbookRight">
                ${sessionScope.mname}
            </td>
        </tr>
        <tr>
            <td class="tb_addbook">
                管理员密码
            </td>
            <td class="tb_addbookRight">
                <input type="password" name="password"
                       value="" />
            </td>
        </tr>
        <tr>
            <td class="tb_addbook">
                二次密码
            </td>
            <td class="tb_addbookRight">
                <input type="password" name="password2"
                       value="" />
            </td>
        </tr>
        <tr>
            <td colspan="2" class="tb_addbookall">

                <div align="center">
                    <input class="input_bg" type="submit" name="Submit" value="提交"
                           onclick="check(form)" />
                    &nbsp;&nbsp;

                    <input class="input_bg" type="reset" name="reset" value="重置" />
                </div>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
