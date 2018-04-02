<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/25 0025
  Time: 16:15
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
    <title>借阅图书</title>
    <script type="text/javascript" language="JavaScript">
        function check(form) {
            if (form.barcode.value == "") {
                alert("图书编号不能为空！");
                form.barcode.focus();
                return false;
            }
            if (form.identiCode.value == "") {
                alert("借书证号不能为空！");
                form.identiCode.focus();
                return false;
            }
        }
    </script>
    <link href="<%=request.getContextPath()%>/css/StyleSheet.css" rel="stylesheet" type="text/css"/>
</head>

<body>

<form id="form1" name="form1" method="post" action="<%=request.getContextPath()%>/BookBorrowBookUserServlet">
    <input type="hidden" name="action" value="borrow">
    <table width="486" border="0" cellpadding="0" cellspacing="0" align="center">
        <tr><input type="hidden" name="operatorid" value="25"/><tr>
            <td class="ZiTie"></td>
        </tr>
        <tr><td class="tb_addbookBgImage" colspan=2>图书借阅</td></tr>
        <tr><td class="tb_addbook" width="197">图书编号</td>
            <td width="273" class="tb_addbookRight">
                <label><input type="text" name="barcode"/></label>
            </td>
        </tr>
        <tr><td class="tb_addbook">借书证号</td>
            <td class="tb_addbookRight"><input type="text" name="identiCode"/></td>
        </tr>
        <tr>
            <td colspan="2" class="tb_addbookall">
                <label>
                    <div align="center">
                        <input class="input_bg" type="submit" name="Submit" value="借阅"
                               onclick="return check(form1)"/>
                        &nbsp;&nbsp;
                        <input class="input_bg" type="reset" name="Submit2" value="重置"/>
                    </div>
                </label>
            </td>
        </tr>
    </table>
</form>
</body>
</html>