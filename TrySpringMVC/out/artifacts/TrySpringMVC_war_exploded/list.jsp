<%--
  Created by IntelliJ IDEA.
  User: lqs
  Date: 2018/4/20
  Time: 1:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>书库</title>
</head>
    <body style="text-align: center">
    <!-- 删除的提交方式 -->
    <%--<form action="" method="POST">--%>
        <%--<input type="hidden" name="_method" value="DELETE">--%>
    <%--</form>--%>

    <c:if test="${empty requestScope.all}">
        没有任何书籍信息
    </c:if>
    <c:if test="${!empty requestScope.all }">
        <table border="1" cellpadding="10" cellspacing="0" style="margin: auto">
            <tr>
                <td>编号</td>
                <td>书名</td>
                <td>作者</td>
                <td>价格</td>
                <td>上架时间</td>
                <td>余量</td>
                <td>类型</td>
                <td>简介</td>
                <td>出版社</td>
                <td>备注</td>
                <td>修改</td>
                <td>删除</td>
            </tr>
            <c:forEach items="${requestScope.all}" var="book">
                <tr>
                    <td>${book.id}</td>
                    <td>${book.name}</td>
                    <td>${book.author}</td>
                    <td>${book.price}</td>
                    <td>${book.grounding_date}</td>
                    <td>${book.allowance}</td>
                    <td>${book.book_type}</td>
                    <td>${book.generalize}</td>
                    <td>${book.press}</td>
                    <td>${book.comments}</td>
                    <td><a href="change/${book.id}">修改</a></td>
                    <td><a href="delete/${book.id}">删除</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <br>
    <h1>
        <a href="add">>>>>>>点击这里新增书目<<<<<<</a>
    </h1>
</body>
</html>
