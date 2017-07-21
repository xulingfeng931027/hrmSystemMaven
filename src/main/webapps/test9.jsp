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
           $("#btn1").click(function () {
               $("#div1").load("/123.txt",function (responseTxt,statusTxt,xhr) {
                   if(statusTxt=="success"){
                       alert(responseTxt)
                   }
               });
           });
           $("#btn2").click(function () {
                 $.get("/GETTest.jsp",function (data,status) {
                    alert("Data:"+data+"\nStatus"+status)
                 });
           });
        });

    </script>
</head>
<body>
  <div id="div1">
      <h2>通过AJAX改变文本</h2>
  </div>
<button id="btn1">这是一个AJAX按钮</button>
  <button id="btn2">这仍然是一个AJAX按钮</button>

</body>
</html>
