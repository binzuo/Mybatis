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
</head>
<body>
<%--在地址栏里直接输入localhost:8080/home.jsp不能直接访问主页 --%>
<c:if test="${sessionScope.username eq null}">
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
<a href="/user?action=logout">log out</a>

</body>
</html>
