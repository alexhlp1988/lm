<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/22
  Time: 14:52
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
<frameset rows="85,*" cols="*" frameborder="yes" border="1" framespacing="0">
    <frame  src="<%=request.getContextPath()%>/back/top.jsp" name="topFrame" scrolling="No" noresize="noresize"   id="topFrame"  title="topFrame" />
    <frameset cols="250,*" frameborder="yes" border="1" framespacing="0">
        <frame   src="<%=request.getContextPath()%>/back/left.jsp" name="leftFrame" scrolling="Yes"  noresize="noresize"  id="leftFrame" title="leftFrame" />
        <frame src="<%=request.getContextPath()%>/back/main.jsp" name="mainFrame" id="mainFrame" title="mainFrame" />
    </frameset>
</frameset>
<noframes>
    <body>
    </body>
</noframes>
</html>
