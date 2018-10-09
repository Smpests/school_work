<%--
  Created by IntelliJ IDEA.
  User: lqs
  Date: 2018/4/20
  Time: 2:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>更改价格</title>
</head>
<body style="text-align: center">
<!--
这个action写成了绝对路径,是因为如果是相对路径,新建的时候没有问题,
而修改的时候会有问题会变成student/student就无法映射了
-->
<form:form action="${pageContext.request.contextPath}/change" method="POST" modelAttribute="book">
    <br />

    <h1>编号:${requestScope.book.id}</h1>
    <h2>名称:${requestScope.book.name}</h2>
    <form:hidden path="id" />
    新价格:
    <form:input path="price" />
    <br />
    <input type="submit" value="确认" />
</form:form>
</body>
</html>
