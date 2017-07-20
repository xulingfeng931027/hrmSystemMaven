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
            $("#btn1").click(function () {
                alert("text" + $("#test").text());
            });
            $("#btn2").click(function () {
                alert("HTML" + $("#test").html);
            });

            $("#btn3").click(function () {
                alert("输入的文字是:" + $("#test2").val());
            });
            $("#btn4").click(function () {
                alert("ddd");
            });
            $("#btn5").click(function () {
                alert("输入的文字是:" + $("#test2").val());
            });
        });

    </script>

</head>
<body>
<p id="test">这是段落中的<b>粗体</b>文本。</p>
文本框:<input type="text" id="test2"/>
<button id="btn1">显示文本</button>
<button id="btn2">显示HTML</button>
<button id="btn3">死循环</button>
<button id="btn4">获取输入值</button>
<button id="btn5">为什么不行</button>

</body>
</html>
