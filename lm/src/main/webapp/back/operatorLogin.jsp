<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/22
  Time: 14:09
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
    <script language="javascript">
        function check(form){
            if (form.name.value==""){
                alert("请输入管理员名称!");form.name.focus();return false;
            }
            if (form.password.value==""){
                alert("请输入管理员密码!");form.pwd.focus();return false;
            }
        }
    </script>
    <link href="../css/StyleSheet.css" rel="stylesheet" type="text/css" />
    <title>管理员登录</title>

</head>
<body>
<br />
<br />
<br />
<br />
<form id="form" name="form" method="post" action="<%=request.getContextPath()%>/LoginServlet" onSubmit="return check(this)" >
    <input name="action" value="login" type="hidden">
    <table align="center" width="600" border="0" cellpadding="8"
           cellspacing="0" class="logintable">
        <tr class="loginheader">
            <td width="80"></td>
            <td width="100"></td>
            <td colspan="2"></td>
            <td width="120"></td>
            <td width="80"></td>
        </tr>
        <tr style="height: 40px">
            <td>
                &nbsp;
            </td>
            <td colspan="4" class="line1">
                <span class="STYLE1">图书馆管理系统登录页面</span>
            </td>
            <td>
                &nbsp;
            </td>
        </tr>
        <tr>
        <tr>
            <td>
                &nbsp;
            </td>
            <td class="line2">
                &nbsp;
            </td>
            <td colspan="2" class="line2">
                &nbsp;
            </td>
            <td class="line2">
                &nbsp;
            </td>
            <td>
                &nbsp;
            </td>
        </tr>
        <tr>
            <td colspan="2">

            </td>
        </tr>
        <tr>
            <td>
                &nbsp;
            </td>
            <td align="right">
                用户名:
            </td>
            <td colspan="2">
                <input type="text" id="mname" name="mname" />
            </td>
            <td></td>
            <td>
                &nbsp;
            </td>
        </tr>
        <tr>
            <td style="height: 32px">
                &nbsp;
            </td>
            <td align="right" style="height: 32px">
                密 码:
            </td>
            <td colspan="2" style="height: 32px">
                <input type="password" id="password" name="password" />
            </td>
            <td style="height: 32px">
                &nbsp;
            </td>
            <td style="height: 32px">
                &nbsp;
            </td>
        </tr>
        <tr>
            <td style="height: 32px">

            </td>
            <td align="right" style="height: 32px">
                验证码：
            </td>
            <td colspan="2" style="height: 32px">
                <input type="text" id="checkcode" name="checkcode" />

            </td>
            <td style="height: 32px">
                <img id="codeImageID" src="<%=request.getContextPath()%>/randomCodeServlet"/>
            </td>
            <td style="height: 32px">
                <div id="tips"></div>
            </td>
        </tr>
        <tr>
            <td style="height: 32px">

            </td>
            <td align="right" style="height: 32px">
                是否记住我<input name="rememberme" type="checkbox">
            </td>
            <td colspan="2" style="height: 32px">
                <select name="expiry">
                    <option value="86400">一天</option>
                    <option value="604800">一周</option>
                    <option value="2592000">一月</option>
                </select>
            </td>
            <td style="height: 32px">
                &nbsp;
            </td>
            <td style="height: 32px">
                &nbsp;
            </td>
        </tr>
        <tr>
            <td style="height: 29px">
                &nbsp;
            </td>
            <td align="right" class="line1" style="height: 29px">
                &nbsp;
            </td>
            <td class="line1" style="width: 71px; height: 29px;">
            </td>
            <td class="line1" style="height: 29px">
            </td>
            <td class="line1" style="height: 29px; font-size: 12px"></td>
            <td style="height: 29px">
                &nbsp;
            </td>
        </tr>
        <tr>
            <td>
                &nbsp;
            </td>
            <td class="line2">
                &nbsp;
            </td>
            <td colspan="2" class="line2">
                <div align="center">
                    &nbsp;
                    <input type="submit" id="btnLogin" width="20" name="Submit" value="提交"
                    />
                    &nbsp;
                    <input type="reset" name="Submit2" value="重置" />
                </div>
            </td>
            <td class="line2">
                &nbsp;
            </td>
            <td>
                &nbsp;
            </td>
        </tr>
        <tr>
            <td colspan="6" style="text-align: center; font-size: 12px">
                Powered by
                <a href="#" target="_blank" style="color: #fff"></a> &nbsp;&copy;
                2008 SunYang
                <a href="#" target="_blank" style="color: #fff"> Inc.</a>
            </td>
        </tr>
        <tr>
            <td>
                &nbsp;
            </td>
            <td>
                &nbsp;
            </td>
            <td colspan="2">
                &nbsp;
            </td>
            <td>
                &nbsp;
            </td>
            <td>
                &nbsp;
            </td>
        </tr>
    </table>
</form>
<script src="../js/jquery-3.2.1.min.js"></script>
<script>
    document.getElementById("codeImageID").onclick=function(){
        //当单击验证码图片,只需要改变一个img标签的src，完成验证码的刷新
        var url="../randomCodeServlet?now="+new Date();
        var imageElement=document.getElementById("codeImageID");
        this.src=url;
        // location.reload();
    }
</script>
</body>
</html>