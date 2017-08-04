<%--
  Created by IntelliJ IDEA.
  User: paul
  Date: 2017-08-02
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://cdn.bootcss.com/json2/20160511/json_parse_state.js"></script>
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.js"></script>
    <script>
        $(document).ready(function () {
            $.ajax(
                {   type:"post"
                    ,contentType: "application/json",
                    url: "/json/test"
                    ,dataType: "json"//期望服务器返回的数据类型
                    , data: JSON.stringify({"id": "1", "name": "paul"})
                    //设置回调函数
                    , success: function (data) {
                    $("#id").html(data.id);
                    $("#name").html(data.name);
                    $("#author").html(data.author);
                }
                    //还可以设置失败函数
                    , error: function () {
                    alert("数据发送失败啊!!!");
                }
                }
            );
        });
    </script>
</head>
<br>
编号:<span id="id"></span></br>
书名:<span id="name"></span></br>
作者:<span id="author"></span></br>
</body>
</html>
