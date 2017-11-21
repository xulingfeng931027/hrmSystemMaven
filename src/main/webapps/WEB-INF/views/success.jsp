<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

    <title>Title</title>
</head>
<body>
                恭喜${user.name}注册成功,生日是<fmt:formatDate value="${user.birthday}"/>1a
</body>
</html>
