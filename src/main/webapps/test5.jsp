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
                $("#p1").css("color", "red").slideDown(2000).slideUp("slow").hide(1000, function () {
                    alert("真他妈好耍!");
                });
            });
        });

    </script>
</head>
<body>
<p id="p1">jQuery 乐趣十足！</p>
<button>点击这里</button>
</body>
</html>
