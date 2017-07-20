<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/7/20 0020
  Time: 0:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <script>
        $(function () {
            $("button").click(function () {
                $("#test").hide();
            });
        });

    </script>
</head>
<body>
<h2>这是一个标题</h2>
<p id="test">这是一个段落</p>
<p>这又是一个段落</p>
<button>这是一个按钮</button>
</body>
</html>
