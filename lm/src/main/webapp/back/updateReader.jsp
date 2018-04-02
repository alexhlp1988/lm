<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/28
  Time: 21:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script language="javascript">
        function check(form) {

            if (form.realName.value == "") {
                alert("读者真实姓名不能为空！");
                form.realName.focus();
                return false;
            }
            if (form.papertype.value == "") {
                alert("证件类型不能为空！");
                form.papertype.focus();
                return false;
            }
            if (form.paperNo.value == "") {
                alert("证件号码不能为空！");
                form.paperNo.focus();
                return false;
            }
        }
    </script>
    <title>修改读者信息</title>
    <link href="<%=request.getContextPath()%>/css/StyleSheet.css" rel="stylesheet" type="text/css"/>
</head>
<body onload="getReaderType()">
<form id="form" name="form" method="post" action="BookUserServlet">
    <input type="hidden" name="id" value="${bookUser.id}"/>
    <input type="hidden" name="action" value="modify"/>
    <table width="345" border="0" cellpadding="0" cellspacing="0"
           align="center">
        <tr>
            <td colspan="2" class="tb_addbookBgImage">
                修改读者信息
            </td>
        </tr>
        <tr>
            <td width="223" class="tb_addbook">
                读者帐号
            </td>
            <td width="223" class="tb_addbookRight">
                <label>
                    ${bookUser.account}
                </label>
            </td>
        </tr>
        <tr>
            <td class="tb_addbook">
                真实姓名
            </td>
            <td class="tb_addbookRight">
                <label>
                    <input type="text" name="realName" value="${bookUser.name}"/>
                </label>
            </td>
        </tr>
        <tr>
            <td class="tb_addbook">
                性别
            </td>
            <td class="tb_addbookRight">
                <label>
                    <input type="radio" name="sex" value="男" ${bookUser.sex=='男'? 'checked':''}/>男
                    <input type="radio" name="sex" value="女" ${bookUser.sex=='女'? 'checked':''}/>女
                </label>
            </td>
        </tr>
        <tr>
            <td class="tb_addbook">
                证件类型
            </td>
            <td class="tb_addbookRight">
                <label>
                    <select name="papertype">
                        <option value="身份证" ${bookUser.cardtype=='身份证' ? 'selected' : ''}>身份证</option>
                        <option value="学生证" ${bookUser.cardtype=='学生证' ? 'selected' : ''}>学生证</option>
                        <option value="军人证" ${bookUser.cardtype=='军人证' ? 'selected' : ''}>军人证</option>
                    </select>
                </label>
            </td>
        </tr>
        <tr>
            <td class="tb_addbook">
                证件号码
            </td>
            <td class="tb_addbookRight">
                <label>
                    <input type="text" name="paperNo" value="${bookUser.card_id}"/>
                </label>
            </td>
        </tr>
        <tr>
            <td class="tb_addbook">
                读者类型
            </td>
            <td class="tb_addbookRight">
                <select name="type">
                    <c:forEach var="but" items="${bookUserTypes}">
                        <option value="${but.typename}" ${bookUser.usertype==but.typename ? 'selected' : ''}>${but.typename}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td colspan="2" class="tb_addbookall">
                <label>

                    <div align="center">
                        <input class="input_bg" type="submit" name="Submit" value="提交"
                               onclick="return check(form)"/>
                        &nbsp;&nbsp;
                        <input class="input_bg" type="reset" name="reset" value="重写"/>
                    </div>
                </label>
            </td>
        </tr>
    </table>
</form>
</body>
</html>