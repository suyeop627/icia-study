<%--
  Created by IntelliJ IDEA.
  User: window
  Date: 2022-10-17
  Time: PM 4:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Js Framework Home</title>
</head>
<body>
    <h1 id = "h">Hello jsp~</h1>

    <%--받은 데이터를 출력할 땐 ${}안에 적는다. attributeName 을 적는다. --%>
    <p>${d}</p>
</body>
<script>
    let h1 = document.getElementById("h");
    h1.style.color="blue";
</script>
</html>
