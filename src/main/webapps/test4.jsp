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
            $("#flip").click(function () {
                $("#panel").slideDown(3000)
            });
            $("#stop").click(function () {
                $("#panel").stop();
            });

        });
    </script>
    <style type="text/css">

        #panel, #flip {
            padding: 5px;
            text-align: center;
            background-color: #e5eecc;
            border: solid 1px #c3c3c3;
        }

        #panel {
            padding: 50px;
            display: none;
        }

    </style>
</head>
<body>
<button id="stop">停止滑动!</button>
<div id="flip">点这里向下滑~~~</div>
<div id="panel">Hello World</div>
</body>
</html>
