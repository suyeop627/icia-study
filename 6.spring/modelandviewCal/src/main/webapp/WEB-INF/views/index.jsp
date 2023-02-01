<%--
  Created by IntelliJ IDEA.
  User: window
  Date: 2022-10-19
  Time: AM 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>calculator</h1>
<form action="calProc">
    <p>
        <input type="number" name = "num1">
    </p>
    <p>
        <input type="number" name = "num2">
    </p>
    <button type = "button">+</button>
    <button type = "button">-</button>
    <button type = "button">*</button>
    <button type = "button">/</button>
    <button type = "button">%</button>
    <input type="hidden" name = "op" id = "op">

    <p><input type = "submit" value ="전송"></p>

</form>



</body>
    <script>
        const btns = document.getElementsByTagName("button");
        const op = document.getElementById("op");
        btns[0].addEventListener("click", function () {
            op.value = "+";
        })
        btns[1].addEventListener("click", function () {
            op.value = "-";
        })
        btns[2].addEventListener("click", function () {
            op.value = "*";
        })
        btns[3].addEventListener("click", function () {
            op.value = "/";
        })
        btns[4].addEventListener("click", function () {
            op.value = "%";
        })

    </script>

</html>
