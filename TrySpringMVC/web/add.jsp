<%--
  Created by IntelliJ IDEA.
  User: lqs
  Date: 2018/4/20
  Time: 2:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Map"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>新增</title>
</head>
<body style="text-align: center">
    <form:form action="${pageContext.request.contextPath}/add" method="POST" modelAttribute="book">
        <br />
        <h1>新增一本书至书库</h1>
        书名
        <form:input path="name"/> <br><br>
        作者
        <form:input path="author"/> <br><br>
        价格
        <form:input path="price"/> <br><br>
        上架时间
        <form:input path="grounding_date"/> <br><br>
        余量
        <form:input path="allowance"/> <br><br>
        类型
        <form:input path="book_type"/> <br><br>
        出版社
        <form:input path="press"/> <br><br>
        <input type="submit" value="提交">
    </form:form>

</body>
</html>
