<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--home page--%>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/11/27
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="common/inc.jsp"%>
<html>
<head>
    <title>home page</title>
    <link rel="stylesheet" href="home.css">
    <style>
        @import url(home.css);
    </style>
    <script src="jQuery/jquery-3.1.1.js"></script>
    <script>
    </script>
</head>
<body>
<%--在地址栏里直接输入localhost:8080/home.jsp不能直接访问主页 --%>
<c:if test="${sessionScope.email eq null}">
    <c:redirect url="index.jsp"/>
</c:if>

${sessionScope.welcome}
<h1>南无地藏菩萨摩诃萨</h1>
<h1>南无本师释迦牟尼佛</h1>
<h1>南无观世音菩萨摩诃萨</h1>
<h1>南无阿弥陀佛</h1>
<h1>南无大势至菩萨摩诃萨</h1>
<h1>南无药师琉璃光如来</h1>
<h1>南无月光遍照菩萨</h1>
<h1>南无日光遍照菩萨</h1>
<h1>南无坚净信菩萨摩诃萨</h1>
<hr>
<form action="${ctx}/book" method="post">
    <input type="hidden" name="action" value="add">
    <input type="text" name="bookTitle" placeholder="书名"><br>
    <input type="text" name="author" placeholder="作者"><br>
    <input type="text" name="publishing" placeholder="出版社"><br>
    <input type="submit" value="ADD">
</form>
<hr>
<h2>书单</h2>
<table border="1" cellspacing="0" cellpadding="10" >
    <tr>
        <th>序号</th>
        <th>书名</th>
        <th>作者</th>
        <th>出版社</th>
        <th colspan="2">操作</th>
    </tr>
    <c:forEach var="book" items="${sessionScope.book}" varStatus="vs">
        <tr>
            <td>${vs.count}</td>
            <td>${book.bookTitle}</td>
            <td>${book.author}</td>
            <td>${book.publishing}</td>
            <td><a href="${ctx}/book?action=search&id=${book.id}">修改</a></td>
            <td><a href="${ctx}/book?action=remove&id=${book.id}">删除</a></td>
        </tr>
    </c:forEach>

</table>


<hr>
<a href="${ctx}/user?action=logout">log out</a>


</body>
</html>
