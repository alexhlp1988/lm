<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/23
  Time: 9:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>管理员信息</title>
    <link href="<%=request.getContextPath()%>/css/StyleSheet.css" rel="stylesheet" type="text/css"/>
</head>

<body>
<center>
    <h2>
        &nbsp;
    </h2>
</center>
<form id="form1" name="form1" method="post" action="">
    <table width="80%" border="0" cellpadding="0" cellspacing="0" align="center">
        <tr>
            <td colspan="8" class="tb_showallbook">
                <div align="center">
                    管理员信息
                </div>
            </td>
        </tr>
        <tr>
            <td class="tb_sabookBorder">
                <div align="center">
                    管理员名称
                </div>
            </td>
            <td colspan="4" class="tb_sabookBorder">
                <div align="center">
                    权限
                </div>
            </td>
            <td class="tb_sabookBorder">
                <div align="center">
                    操作
                </div>
            </td>
        </tr>
        <c:forEach var="manager" items="${pager.rows}">
            <tr>
                <td class="tb_sabookMain">
                    <div align="center">${manager.mname}</div>
                </td>
                <td colspan="4" class="tb_sabookMain">
                    <div>
                        <c:forTokens items="${manager.rights}" delims=","
                                     var="s" varStatus="row" step="1" begin="0" end="3">
                            ${s}&nbsp;&nbsp;&nbsp;&nbsp;
                        </c:forTokens>
                    </div>
                </td>
                <td class="tb_sabookMain">
                    <a href="ManagerServlet?action=detail&id=${manager.id}">修改</a>
                    <a href="ManagerServlet?action=delete&id=${manager.id}" onclick="return confirm('是否确认删除 ${manager.mname} ?')">删除</a>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="8">
                <select id="rows" onchange="on_change()">
                    <option value="5" ${rows==5?'selected':''}>5</option>
                    <option value="10" ${rows==10?'selected':''}>10</option>
                    <option value="15" ${rows==15?'selected':''}>15</option>
                    <option value="20" ${rows==20?'selected':''}>20</option>
                </select>
                <span style="color: #000;">第${page}页&nbsp;</span>
                <a href="ManagerServlet?page=1&rows=${rows}&sort=${sort}&order=${order}">首页</a>
                <a href="ManagerServlet?page=${page-1<1?1:page-1}&rows=${rows}&sort=${sort}&order=${order}">上一页</a>
                <a href="ManagerServlet?page=${page+1>pageSize?pageSize:page+1}&rows=${rows}&sort=${sort}&order=${order}">下一页</a>
                <a href="ManagerServlet?page=${pageSize}&rows=${rows}&sort=${sort}&order=${order}">末页</a>
                <!--input type="number" max="${pageSize}" id="page" min="1" onkeypress="on_keypress(event)"-->
                <span style="color: #000;">共${pageSize}页&nbsp;
                    共${pager.total}条数据&nbsp;</span>
            </td>
        </tr>
    </table>
</form>
<script>
    function on_change() {
        var rows = document.getElementById("rows").value;
        location.href = "ManagerServlet?page=1&rows=" + rows + "&sort=${sort}&order=${order}";
    }
    function on_keypress(event) {
        if (event.keyCode == 13) {
            var page = document.getElementById("page").value;
            //alert(page);
            //alert("ManagerServlet?page=" + page + "&rows=${rows}&sort=${sort}&order=${order}")
            //要在框架中跳转
            window.parent.mainFrame.location.href = "ManagerServlet?page=" + page + "&rows=${rows}&sort=${sort}&order=${order}";

        }
    }
</script>
</body>
</html>
