<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/23 0023
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script type="text/javascript" language="JavaScript">
        function getType() {
            DWRMethods.getBookTypes(function (types) {
                dwr.util.removeAllOptions("bookTypes");
                dwr.util.addOptions("bookTypes", types);
            });
        }

        function submitForm() {
            var userName = document.getElementById("name");
            var userPassword = document.getElementById("password");
            if (userName.value == null || userName.value == "") {
                alert("帐号不能为空!");
                userName.focus();
                return false;
            }
            if (userPassword.value == null || userPassword.value == "") {
                alert("密码不能为空!");
                userPassword.focus();
                return false;
            }
            document.location = "showBorrowedBooks.html";

        }

        function disableAll() {
            document.getElementById("date").style.display = "none";
            document.getElementById("names").style.display = "none";
            document.getElementById("bookType").style.display = "none";
            document.getElementById("finder").style.display = "none";
        }

        function findType() {
            if (document.getElementById("typer").value == "bookName" || document.getElementById("typer").value == "publisher" || document.getElementById("typer").value == "author") {
                document.getElementById("names").style.display = "inline";
                document.getElementById("date").style.display = "none";
                document.getElementById("bookType").style.display = "none";
                document.getElementById("finder").style.display = "inline";
            } else if (document.getElementById("typer").value == "booktypeT") {
                document.getElementById("bookType").style.display = "inline";
                document.getElementById("date").style.display = "none";
                document.getElementById("names").style.display = "none";
                document.getElementById("finder").style.display = "inline";
            } else if (document.getElementById("typer").value == "inTime") {
                document.getElementById("bookType").style.display = "none";
                document.getElementById("names").style.display = "none";
                document.getElementById("date").style.display = "inline";
                document.getElementById("finder").style.display = "inline";
            }
            if (document.getElementById("typer").value == "-1") {
                disableAll();
            }
        }


    </script>
    <style type="text/css">
        .index_main {
            background-color: #990000;
            border-left: 1px solid #FF66FF;
            border-top: 1px solid #FF66FF;
            color: #FFFFFF;
            padding-top: 3px;
            padding-left: 3px;
            font-weight: bold;
        }

        .index_tbmain {
            background-color: #FFFBD6;
            border-left: 1px solid #FF66FF;
            border-top: 1px solid #FF66FF;
            color: #000000;
        }
    </style>
    <title>图书馆管理系统|前台首页</title>
</head>
<body style="font: 12px;" onLoad="disableAll(),getType();">
<!---图片区域-->

<table width="950" border="0" align="center" cellpadding="0"
       cellspacing="0"
       style="border: 1px solid #83ACC0; background-color: #F8FCFD;">
    <tr>
        <td width="20%">
            &nbsp;
        </td>
        <td width="68%" height="90px"
            style="background-image: url(<%=request.getContextPath()%>/image/3029601.gif)"></td>
        <td width="1%" valign="top"></td>
        <td width="11%" align="center">
            <table border="0" cellpadding="0" cellspacing="0">
                <tr>
                    <td width="13">
                        <li></li>
                    </td>
                    <td width="83">
                        <a href="#"
                           onClick="this.style.behavior='url(#default#homepage)';this.sethomepage('http://www.sunyang.net.cn');return false;"
                           title="将本站设为你的首页">设为主页</a>
                    </td>
                </tr>
                <tr>
                    <td height="19">
                        <li></li>
                    </td>
                    <td>
                        <a href="mailto:admin@sunyang.net.cn" title="有什么意见请联系我们">联系我们</a>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>


<table width="950" border="0" align="center" cellpadding="0"
       cellspacing="0">
    <tr>
        <td height="5px"></td>
    </tr>
</table>
<table width="950" border="0" align="center" cellpadding="0"
       cellspacing="0">
    <tr>
        <td width="195" height="265" valign="top">
            <!--主体区域-->
            <form action="showLiberInfoFront1.html" method="post">
                <table width="222" height="178" id="tt1" cellpadding="0"
                       cellspacing="0">
                    <tr align="center">
                        <td width="212" height="29" bgcolor="#015890">
                            <strong><font color="#FFFFFF">信息搜索</font> </strong>
                        </td>
                    </tr>
                    <tr align="center">
                        <td style="border: 1px solid #CCCCCC" height="133"
                            bgcolor="#ffffff">
                            分类:
                            <select name="typer" onChange="findType();">
                                <option value="-1">请选择</option>
                                <option value="author">作者</option>
                                <option value="publisher">出版社</option>
                                <option value="bookName">书名</option>
                                <option value="inTime">上架日期</option>
                                <option value="booktypeT">类型</option>
                            </select>
                        </td>
                    </tr>
                </table>
            </form>
            <c:if test="${empty sessionScope.account}">
                <form id="readerform" name="readerform" method="post"
                      action="../LoginBookUserServlet">
                    <input name="action" value="login" type="hidden">
                    <table height="144"
                           style="background-color: #ffffff; border: 1px solid #CCCCCC">
                        <tr align="center">
                            <th width="198" height="31" bgcolor="#015890" colspan=2>
                                <strong><font color="#FFFFFF">用户登录</font> </strong>
                            </th>
                        </tr>
                        <tr align="center">
                            <td colspan="2"></td>
                        </tr>
                        <tr align="center">
                            <td width="42" height="47">
                                <div align="center">帐号:
                                </div>
                            </td>
                            <td width="168"><input type="text" name="account"/></td>
                        </tr>
                        <tr align="center">
                            <td height="49">密码:</td>
                            <td><input type="password" name="password"/></td>
                        </tr>
                        <tr>
                            <td colspan="2" height="46">
                                是否记住我 <input name="rememberme" type="checkbox">
                                <select name="expiry">
                                    <option value="86400">一天</option>
                                    <option value="604800">一周</option>
                                    <option value="2592000">一月</option>
                                </select><br>
                            </td>
                        </tr>
                        <tr align="center">
                            <td height="46"></td>
                            <td>
                                <button type="submit">登录</button>
                                <input type="reset" name="reset" value="清空"/></td>
                        </tr>
                    </table>
                </form>
            </c:if>
            <c:if test="${!empty sessionScope.account}">
                欢迎${sessionScope.account}<a
                    href='<%=request.getContextPath()%>/LoginBookUserServlet?action=logout'>注销</a>
            </c:if>

        </td>
        <td valign="top">
            <c:if test="${empty sessionScope.account}">
                <img src="../image/lm.jpg" width="600" height="480">
            </c:if>
            <c:if test="${!empty sessionScope.account}">
                <!--主页右部分 -->
                <form action="BorrowServlet" method="post" name="f">
                    <input type="hidden" name="action" value="modify">
                    <table border=0 align="center" cellpadding="0" cellspacing="0">
                        <tr>
                            <td class="index_main">书名</td>
                            <td class="index_main">作者</td>
                            <td class="index_main">出版社</td>
                            <td class="index_main">图书类型</td>
                            <td class="index_main">上架时间</td>
                            <td class="index_main">价格</td>
                            <td class="index_main">图书编号</td>
                            <td class="index_main">借阅情况</td>
                            <td class="index_main">借阅申请</td>
                            <td class="index_main">还书申请</td>
                        </tr>
                        <c:forEach var="book" items="${books}">
                            <tr onMouseOut="this.style.backgroundColor='#FFFBD6'"
                                onMouseOver="this.style.backgroundColor='#FFF7E7'">
                                <td class="index_tbmain">${book.name}</td>
                                <td class="index_tbmain">${book.author}</td>
                                <td class="index_tbmain">${book.publisher}</td>
                                <td class="index_tbmain">${book.book_type}</td>
                                <td class="index_tbmain"><fmt:formatDate value="${book.sign_date}"
                                                                         pattern="yyyy-MM-dd"/></td>
                                <td class="index_tbmain"><fmt:formatNumber value="${book.price}"
                                                                           pattern="########.00"/></td>
                                <td class="index_tbmain">${book.isbn}</td>
                                <td class="index_tbmain">
                                        ${book.is_back==null?'未借出':''}
                                        ${book.is_back==1?'已借出':''}
                                        ${book.is_back==2?'审核借书中':''}
                                        ${book.is_back==3?'审核还书中':''}
                                        ${book.is_back==4?'已归还':''}
                                </td>
                                <td>
                                    <button type="button" onclick="toborrow(${book.id})">借阅</button>
                                </td>
                                <td>
                                    <button type="button" onclick="doborrow(${book.id})">还书</button>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </form>
            </c:if>
        </td>

    </tr>
</table>
<table width="950" border="0" align="center" cellpadding="0"
       cellspacing="0">
    <tr>
        <td style="border-left: 1px solid #83ACC0; border-top: 1px solid #83ACC0; border-right: 1px solid #83ACC0; padding-left: 5px; padding-top: 3px; padding-bottom: 2px; border-bottom: 1px solid #83ACC0">
            版权信息
        </td>
    </tr>
    <tr>
        <td height="38" align="center" style="border: 1px solid #83ACC0">
            Copyright? 2018 WYL. All Rights Resered .
        </td>
    </tr>
</table>
<br>
<br>
<script>
    function toborrow(bookid) {
        location.href = "BorrowServlet?action=modify&book_id=" + bookid;
    }

    function doborrow(bookid) {
        location.href = "BorrowServlet?action=return&book_id=" + bookid;
    }
</script>
</body>

</html>