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
        $(document).ready(function () {
            $(".flip").click(function () {
                $(".panel").slideToggle("slow", function () {
                    alert("执行成功!!!")
                })
            });
        });
    </script>
    <style type="text/css">
        div.panel, p.flip {
            margin: 0px;
            padding: 5px;
            text-align: center;
            background: #e5eecc;
            border: solid 1px #c3c3c3;
        }

        div.panel {
            height: 120px;
            display: none;
        }
    </style>
</head>
<body>
<div class="panel">
    <p>这是一行文字</p>
    <p>这也是一行文字</p>
</div>
<p class="flip">请点我!!!</p>
</body>
</html>
