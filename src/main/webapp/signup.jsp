                   <%--signup page--%>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/11/27
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
                   <%@ include file="common/inc.jsp"%>
<html>
<head>
    <title>sign up</title>
</head>
<body>
<form action="${ctx}/user" method="post">
<input type="hidden" name="action" value="register">
<input type="text" name="email" placeholder="邮箱" value="18310996173xiaozuo@gmail.com"><br>
<input type="password" name="password" placeholder="PASSWORD" value="123"><br>
<input type="submit" value="sign up">

</form>

</body>
</html>
