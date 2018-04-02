<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/22
  Time: 16:01
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
    <title>增加图书类型</title>
    <link href="../css/StyleSheet.css" rel="stylesheet" type="text/css" />
    <script language="javascript">
        function check(form){
            if(form.name.value==""){
                form.name.focus();
                alert("类型名称不能为空!");
                return false;
            }

        }
    </script>
</head>
<body>
<form id="form" name="form" method="post" action="../BookTypeServlet">
    <input type="hidden" name="action" value="add">
    <table width="323" height="110" border="0" cellpadding="0"
           cellspacing="0" align="center">
        <tr>
            <td colspan="2" class="tb_addbookBgImage">
                增加图书类型
            </td>
        <tr>
            <td width="121" class="tb_addbook">
                类型名称
            </td>
            <td width="186" class="tb_addbookRight">
                <label>
                    <input type="text" name="name" />
                </label>
            </td>
        <tr>
            <td colspan="2" class="tb_addbookall">
                <div align="center">
                    <input class="input_bg" type="submit" name="Submit" value="提交"
                           onclick="return check(form)" />
                    <input class="input_bg" type="reset" name="reset" value="重置" />
                </div>
            </td>
        </tr>
    </table>
</form>
</body>
</html>