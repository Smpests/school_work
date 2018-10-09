<%--
  Created by IntelliJ IDEA.
  User: lqs
  Date: 2018/4/12
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>分析结果</title>
</head>
<body style="text-align: center">
<a href="home">返回</a>
    <div style="width: 100%">
        <div style="width: 40%;float: left" id="result" class="result">
            <b>分析结果</b><br>
            <c:if test="${empty requestScope.result}">
                <b>${message}</b>
            </c:if>
            <c:if test="${!empty requestScope.result}">
                <table border="1" cellpadding="10" cellspacing="0" style="margin: auto">
                    <c:forEach items="${requestScope.result}" var="item">
                        <tr>
                            <td>${item}</td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
        </div>
        <div style="width: 40%;float: left" id="symbols" class="symbols">
            <b>符号表</b><br>
            <c:if test="${!empty requestScope.symbols}">
                <table border="1" cellspacing="0" cellpadding="10" style="margin: auto">
                    <c:forEach items="${requestScope.symbols}" var="item">
                        <tr>
                            <td>${item.address}</td>
                            <td>${item.name}</td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
        </div>
    </div>
    <div style="color: red;">
        <b>ERROR</b><br>
        <c:if test="${!empty requestScope.error}">
            <table border="1" cellspacing="0" cellpadding="10">
                <c:forEach items="${requestScope.error}" var="item">
                    <tr>
                        <td>${item}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </div>
</body>
</html>
