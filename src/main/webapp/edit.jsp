<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/1 0001
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="common/inc.jsp"%>
<html>
<head>
    <title>edit page</title>
</head>
<body>
<form action="${ctx}/book" method="post">
    <input type="hidden" name="action" value="update">
    <input type="text" name="bookTitle" placeholder="书名"><br>
    <input type="text" name="author" placeholder="作者"><br>
    <input type="text" name="publishing" placeholder="出版社"><br>
    <input type="submit" value="save">
</form>
</body>
</html>
