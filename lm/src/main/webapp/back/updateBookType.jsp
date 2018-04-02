<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/25
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script language="javascript">
        function check(form){
            if(form.name.value==""){
                alert("类型名称不能为空");
                return false;
            }
        }
    </script>
    <title>修改图书类型</title>
    <link href="<%=request.getContextPath()%>/css/StyleSheet.css" rel="stylesheet" type="text/css" />
</head>
<body>
<form id="form" name="form" method="post" action="BookTypeServlet">
    <table width="323" border="0" cellpadding="0" cellspacing="0"
           align="center">

        <input type="hidden" name="id" value="${bookType.id}" />
        <input type="hidden" name="action" value="modify" />
        <tr>
            <td colspan="2" class="tb_addbookBgImage">
                修改图书类型
            </td>
        </tr>
        <tr>
            <td width="121" class="tb_addbook">
                类型名称
            </td>
            <td width="186" class="tb_addbookRight">
                <label>
                    <input type="text" name="name" value="${bookType.typename}" />
                </label>
            </td>
        </tr>

        <tr>
            <td colspan="2" class="tb_addbookall">
                <label>
                    <div align="center">
                        <input class="input_bg" type="submit" name="Submit" value="提交"
                               onclick="return check(form)" />
                        <input class="input_bg" type="reset" name="Reset" value="重置" />
                    </div>
                </label>
            </td>
        </tr>
    </table>
</form>
</body>
</html>