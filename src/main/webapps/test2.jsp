<%--
  Created by IntelliJ IDEA.
  User: paul
  Date: 2017-07-20
  Time: 15:23
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
                $("#div1").fadeTo("slow", 0.15);
                $("#div2").fadeTo("slow", 0.15);
                $("#div3").fadeTo("slow", 0.15);
            });
        });

    </script>
</head>
<body>

<p>演示带有不同参数的 fadeTo() 方法。</p>
<button>点击这里，使三个矩形淡出</button>
<br><br>
<div id="div1" style="width:80px;height:80px;background-color:red;"></div>
<br>
<div id="div2" style="width:80px;height:80px;background-color:green;"></div>
<br>
<div id="div3" style="width:80px;height:80px;background-color:blue;"></div>
</body>
</html>
