<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/22
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script language="javascript">
        function check(form){
            if(form.name.value==""){
                alert("读者名称不能为空！");
                form.name.focus();return false;
            }
            if(form.realName.value==""){
                alert("读者真实姓名不能为空！");
                form.name.focus();return false;
            }
            if(form.tel.value==""){
                alert("读者电话不能为空！");
                form.tel.focus();return false;
            }
            if(form.paperNo.value==""){
                alert("证件号码不能为空!");
                form.name.focus();
                return false;
            }
            var temp = document.getElementById("email");
            //对电子邮件的验证
            var emailStr = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;

            if(!emailStr.test(temp.value)){
                alert("提示\n\n请输入有效的E_mail!");
                temp.focus();
                return false;
            }
            var temp = document.getElementById("tel");
            //对电话号码的验证
            var telStr = /^[0-9]*$/;
            if(!telStr.test(temp.value)){
                alert("提示\n\n请输入有效的电话号码!");
                temp.focus();
                return false;
            }
        }


    </script>
    <title>增加读者</title>
    <link href="<%=request.getContextPath()%>/css/StyleSheet.css" rel="stylesheet" type="text/css" />
</head>

<body onload="getReaderType();">

<form id="form" name="form" method="post"
      action="<%=request.getContextPath()%>/BookUserServlet">
    <input type="hidden" name="action" value="add">
    <table width="345" border="0" cellpadding="0" cellspacing="0"
           align="center">
        <tr>
            <td colspan="2" height="25" class="tb_addbookBgImage">
                增加读者
            </td>
        </tr>
        <tr>
            <td width="106" class="tb_addbook">
                读者帐号
            </td>
            <td width="223" class="tb_addbookRight">
                <label>
                    <div id="nameChecker"></div>
                    <input type="text" name="name" onblur="checkName()" />
                </label>
            </td>
        </tr>
        <tr>
            <td width="106" class="tb_addbook">
                密码
            </td>
            <td width="223" class="tb_addbookRight">
                <label>
                    <div id=""></div>
                    <input type="password" name="password" required />
                </label>
            </td>
        </tr>
        <tr>
            <td class="tb_addbook">
                真实姓名
            </td>
            <td class="tb_addbookRight">
                <label>
                    <input type="text" name="realName" />
                </label>
            </td>
        </tr>
        <tr>
            <td class="tb_addbook">
                性别
            </td>
            <td class="tb_addbookRight">
                <label>
                    <input type="radio" name="sex" value="男" checked="checked" />
                    男
                    <input type="radio" name="sex" value="女" />
                    女
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
                        <option value="身份证">身份证</option>
                        <option value="学生证">学生证</option>
                        <option value="军人证">军人证</option>
                    </select>
                </label>
            </td>
        </tr>
        <tr>
            <td class="tb_addbook">证件号码</td>
            <td class="tb_addbookRight">
                <label>
                    <input type="text" name="paperNo" />
                </label>
            </td>
        </tr>
        <tr>
            <td width="106" class="tb_addbook">
                借书证号
            </td>
            <td width="223" class="tb_addbookRight">
                <label>
                    <div id=""></div>
                    <input type="text" name="lcard" required />
                </label>
            </td>
        </tr>
        <tr>
            <td class="tb_addbook">
                电话
            </td>
            <td class="tb_addbookRight">
                <label>
                    <input type="text" name="tel" />
                </label>
            </td>
        </tr>
        <tr>
            <td class="tb_addbook">电子邮箱</td>
            <td class="tb_addbookRight">
                <label>
                    <input type="text" name="email" />
                </label>
            </td>
        </tr>
        <tr>
            <td class="tb_addbook">读者类型</td>
            <td class="tb_addbookRight">
                <label>
                    <select name="type">
                        <c:forEach var="but" items="${requestScope.bookUserTypes}">
                        <option>${but.typename}</option>
                        </c:forEach>
                    </select>
                </label>
            </td>
        </tr>
        <tr>
            <td class="tb_addbook">备注</td>
            <td class="tb_addbookRight">
                <label>
                    <textarea name="description"></textarea>
                </label>
            </td>
        </tr>
        <tr>
            <td colspan="2" class="tb_addbookall">
                <label>

                    <div align="center">
                        <input class="input_bg" type="submit" name="Submit" value="提交"
                               onclick="return check(form)" />

                        <input class="input_bg" type="reset" name="reset" value="重写" />
                    </div>
                </label>
            </td>
        </tr>
    </table>
</form>

</body>

</html>
