<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/23
  Time: 11:12
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
    <title>更新管理员信息</title>
    <link href="<%=request.getContextPath()%>/css/StyleSheet.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<form id="form" name="form1" method="post" action="<%=request.getContextPath()%>/ManagerServlet">
    <table border="0" cellpadding="0" cellspacing="0" align="center">
        <input type="hidden" name="action" value="modify">
        <input type="hidden" name="id" value="${manager.id}"/>
        <tr>

            <td colspan="2" class="tb_addbookBgImage">
                修改管理员权限
            </td>
        <tr>
            <td class="tb_addbook">
                管理员帐号
            </td>
            <td class="tb_addbookRight">
                <input type="text" name="mname" value="${manager.mname}" readonly>
            </td>
        </tr>
        <tr>
            <td class="tb_addbook">
                权限选择
            </td>
            <td class="tb_addbookRight">
                <input type="checkbox" name="rights" value="图书操作"
                ${book=='图书操作'? 'checked':''}
                />
                图书操作权限
                <input type="checkbox" name="rights" value="借还操作"
                ${borrow=='借还操作'? 'checked':''}
                />
                借还操作权限
                <input type="checkbox" name="rights" value="读者操作"
                ${reader=='读者操作'? 'checked':''}
                />
                读者操作权限
                <input type="checkbox" name="rights" value="管理员操作"
                ${manage=='管理员操作'? 'checked':''}
                />
                管理员操作权限
            </td>
        </tr>
        <tr>
            <td colspan="2" class="tb_addbookall">

                <div align="center">
                    <input class="input_bg" type="submit" name="Submit" value="提交"/>
                    &nbsp;&nbsp;

                    <input class="input_bg" type="reset" name="Reset" value="重置"/>
                </div>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
