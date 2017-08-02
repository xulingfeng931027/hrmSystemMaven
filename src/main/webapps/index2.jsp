<%--
  Created by IntelliJ IDEA.
  User: paul
  Date: 2017-08-02
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://cdn.bootcss.com/json2/20160511/json_parse_state.js"></script>
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.js"></script>
    <script>
        $(document).ready(function () {
            $.post(
                "${pageContext.request.contextPath}/json/testRequestBody",
                //发送请求的url自负擦混
                {
                    dataType: "json"//期望服务器返回的数据类型
                    , contentType: "application/json"
                    //设置回调函数
                    , success: function (data) {
                    console.log(data);
                    $("#id").html(data.id);
                    $("#name").html(data.name);
                    $("#author").html(data.author);
                }
                //还可以设置失败函数
                    ,error:function () {
                    alert("数据发送失败啊!!!");
                }
                }
            );
        });
    </script>
</head>
<br>
编号:<span id="id"/></br>
书名:<span id="name"/></br>
作者:<span id="author"/></br>
</body>
</html>
