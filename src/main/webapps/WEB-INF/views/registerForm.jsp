<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: paul
  Date: 2017-08-22
  Time: 19:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.js"></script>

    <title>注册页面</title>
</head>
<body>
<h3>注册页面</h3>
<sf:form action="${pageContext.request.contextPath}/register" method="post" commandName="user">
    <table>
        <tr>
            <td>姓名</td>
            <td><input type="text" name="name"/></td>
            <td><sf:errors path="name" cssStyle="color:red"/></td>
        </tr>
        <tr>
            <td>生日</td>
            <td><input type="text" name="birthday"/></td>
            <td><sf:errors path="birthday" cssStyle="color:red"/></td>
        </tr>
        <tr>
            <td>邮箱</td>
            <td><input type="text" name="email"/></td>
            <td><sf:errors path="email" cssStyle="color:red"/></td>
        </tr>
        <tr>
            <td>链接</td>
            <td><input type="text" name="url"/></td>
            <td><sf:errors path="url" cssStyle="color:red"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="注册!!!"/></td>
        </tr>
    </table>
</sf:form>
</body>
</html>
