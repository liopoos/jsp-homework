<%--
  Created by IntelliJ IDEA.
  User: hades
  Date: 2017/5/10
  Time: 20:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>JSP大作业</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="./">JSP大作业</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="login.jsp">登录</a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="container">
    <div class="jumbotron">
        <h1>Hello, world!</h1>
        <p>这是JSP大作业，在实验4的基础上，实现一个完整的Web应用系统的用户登录验证过程。</p>
        <h4>本次实现功能：</h4>
        <ul>
            <li class="list-unstyled"><strong>JSP页面包括：</strong></li>
            <li class="list-unstyled">登录页面；注册页面；登录成功页面；注册成功页面；登录失败页面；注册失败页面</li>
            <li class="list-unstyled"><strong>Servlet包括：</strong></li>
            <li class="list-unstyled">登录控制；注册控制；页面编码过滤器实现。</li>
            <li class="list-unstyled"><strong>JavaBean包括：</strong></li>
            <li class="list-unstyled">用户实体Bean；登录验证Bean；注册Bean（写入数据库）；数据库连接及应用Bean。</li>
        </ul>
        <a href="login.jsp" class="btn btn-primary">登录</a>
        <a href="reg.jsp" class="btn btn-success">注册</a>
    </div>
</div>
</body>
</html>
