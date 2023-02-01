<%--
  Created by IntelliJ IDEA.
  User: window
  Date: 2022-10-18
  Time: AM 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>처음</title>
</head>
<body>
<h1>계산</h1>
<form action="calProc" method="get">
    <input type="number" name="num1">
    <input type="number" name="num2">



    <select name="operator">
        <option value="+">+</option>
        <option value="-">-</option>
        <option value="*">*</option>
        <option value="/">/</option>
    </select>

<input type="submit" value="결과확인">
</form>

</body>
</html>
