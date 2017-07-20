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
            $("#p").click(function () {
                $("p").append("<b>哈哈哈哈</b>");
            });
            $("#ul").click(function () {
                $("ul").append("<li>嘿嘿嘿嘿</li>");
            });
        });

        function appendText() {
            var txt1 = "<p>Text.</p>";              // 以 HTML 创建新元素
            var txt2 = $("<p></p>").text("Text.");  // 以 jQuery 创建新元素
            var txt3 = document.createElement("p");
            txt3.innerHTML = "Text.";               // 通过 DOM 来创建文本
            $("body").append(txt1, txt2, txt3);        // 追加新元素
        }

    </script>

</head>
<body>
<p>这是p区域</p>
<ul>
    <li>1</li>
    <li>2</li>
</ul>
<button id="p">给p区域追加</button>
<button id="ul">给ul区域追加</button>
<button onclick="appendText()">追加文本</button>
</body>
</html>
