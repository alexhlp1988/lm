<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/23
  Time: 10:14
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
            if (form.name.value==""){
                alert("请输入管理员名称!");
                form.name.focus();
                return false;
            }
            if (form.password.value==""){
                alert("请输入管理员密码!");
                form.password.focus();
                return false;
            }
            if (form.password.value!=form.password2.value){
                alert("两次输入的密码不一致!");
                form.password2.focus();
                return false;
            }
        }

    </script>
    <title>增加新的管理员</title>
    <link href="../css/StyleSheet.css" rel="stylesheet" type="text/css" />
</head>

<body>

<form id="form" name="form1" method="post" action="<%=request.getContextPath()%>/ManagerServlet">
    <table border="0" cellpadding="0" cellspacing="0" align="center">
        <input type="hidden" name="action" value="add">

        <tr>
            <td colspan="2" class="tb_addbookBgImage">
                增加新的管理员
            </td>
        </tr>
        <tr>
            <td width="80" class="tb_addbook">
                管理员帐号
            </td>
            <td width="468" class="tb_addbookRight">
                <div id="nameChecker"></div>
                <input type="text" name="mname" value=""  />
            </td>
        </tr>
        <tr>
            <td class="tb_addbook">
                管理员密码
            </td>
            <td class="tb_addbookRight">
                <input type="password" name="password" value="" />
            </td>
        </tr>
        <tr>
            <td class="tb_addbook">
                二次密码
            </td>
            <td class="tb_addbookRight">
                <input type="password" name="password2" value="" />
            </td>
        </tr>
        <tr>
            <td class="tb_addbook">
                权限选择
            </td>
            <td class="tb_addbookRight">
                <input type="checkbox" name="rights" value="图书操作" />
                图书操作权限
                <input type="checkbox" name="rights" value="借还操作" />
                借还操作权限
                <input type="checkbox" name="rights" value="读者操作" />
                读者操作权限
                <input type="checkbox" name="rights" value="管理员操作" />
                管理员操作权限
            </td>
        </tr>
        <tr>
            <td colspan="2" class="tb_addbookall">

                <div align="center">
                    <input class="input_bg" type="submit" name="Submit" value="提交"
                           onclick="return check(form)" />

                    <input class="input_bg" type="reset" name="Reset" value="重置" />
                </div>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
