<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/11/27
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>sign up</title>
</head>
<body>
<form action="/user" method="post">
<input type="hidden" name="action" value="register">
<input type="text" name="username" placeholder="USERNAME" value="18310996173@gmail.com">username<br>
<input type="password" name="password" placeholder="PASSWORD" value="123">password<br>
<input type="submit" value="sign up">

</form>

</body>
</html>
