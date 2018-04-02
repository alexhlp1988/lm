<%--
  Created by IntelliJ IDEA.
  User: 黄鹏
  Date: 2018/1/22
  Time: 10:10
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
    <title>Document</title>
</head>
<body>
<br />
<br />
<table width="520" border=0 align=center cellpadding=3 cellspacing=1
       style="border: 1px #3795D2 solid; background-color: #FFFFFF; font-size: 12px;">
    <tr>
        <th
                style="background-color: #3795D2; color: white; font-size: 20px; font-weight: bold; height: 26px;">
            欢迎访问图书馆管理系统
        </th>
    </tr>
    <tr>
        <td
                style="background-color: #F7F7F7; font-size: 12px; height: 20px; color: blue">
            &nbsp;
        </td>
    </tr>
    <tr>
        <td
                style="background-color: #F7F7F7; font-size: 12px; height: 40px; text-align: center">
            <li>
                <a href="IndexBookUserServlet">进入前台页面</a>

            </li>
            <br />
            <li>
                <a href="IndexServlet">进入后台页面</a>
            </li>
        </td>
    </tr>
    <tr>
        <td align=center
            style="background-color: #F0F0F0; font-size: 12px; height: 20px;">
					<span
                            style="background-color: #F7F7F7; font-size: 12px; height: 20px; color: blue">&nbsp;&nbsp;<span
                            id="jump">15</span> 秒钟后本窗口将自动关闭</span>
        </td>
    </tr>
    <tr>
        <td align=center
            style="background-color: #F0F0F0; font-size: 12px; height: 20px;">
            【
            <a href='javascript:onclick=window.close()'>关闭本窗口</a>】
        </td>
    </tr>
</table>
<script language="JavaScript">
    function countDown(secs){
        jump.innerText=secs;if(--secs>0)setTimeout("countDown("+secs+")",1000);
    }
    countDown(15);
    setTimeout('window.close();', 15000);
</script>
</body>
</html>
