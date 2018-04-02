<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/25
  Time: 15:18
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
                alert("类型名称不能为空！");
                return false;
            }
            if(form.quantity.value==""){
                alert("可借数量不能为空！");
                return false;
            }

            var temp = document.getElementById("quantity");
            //对数量的验证
            var quantityStr = /^[1-9]+[0-9]*$/;
            if(!quantityStr.test(temp.value))
            {
                alert('提示\n\n请输入正确的可借数量');
                temp.focus();
                return false;
            }
        }
    </script>
    <title>修改读者类型</title>
    <link href="<%=request.getContextPath()%>/css/StyleSheet.css" rel="stylesheet" type="text/css" />
</head>

<body>
<form id="form" name="form" method="post" action="<%=request.getContextPath()%>/BookUserTypeServlet">
    <table width="323" border="0" cellpadding="0" cellspacing="0"
           align="center">

        <input type="hidden" name="id" value="${bookUserType.id}" />
        <input type="hidden" name="action" value="modify" />
        <tr>
            <td colspan="2" class="tb_addbookBgImage">
                修改读者类型
            </td>
        </tr>
        <tr>
            <td width="121" class="tb_addbook">
                类型名称
            </td>
            <td width="186" class="tb_addbookRight">
                <label>
                    <input type="text" name="name" value="${bookUserType.typename}" />
                </label>
            </td>
        </tr>
        <tr>
            <td class="tb_addbook">
                可借数量
            </td>
            <td class="tb_addbookRight">
                <label>
                    <input type="text" name="quantity" value="${bookUserType.book_count}" />
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
                        <input class="input_bg" type="reset" name="Reset" value="重置" />
                    </div>
                </label>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
