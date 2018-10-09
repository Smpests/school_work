<%--
  Created by IntelliJ IDEA.
  User: lqs
  Date: 2018/4/12
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>JAVA词法分析</title>
  </head>
<div style="text-align: center">
    <form action="analysis" method="post">
        <b>请输入要分析的文件名:</b><input type="text" name="file" id="file" required="required">
        <input type="submit" value="分析">
    </form>
</div>
</html>