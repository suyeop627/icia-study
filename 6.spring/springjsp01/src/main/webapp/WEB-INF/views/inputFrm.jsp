<%--
  Created by IntelliJ IDEA.
  User: window
  Date: 2022-10-18
  Time: PM 1:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>입력 화면</title>
</head>
<body>
<h1>사용자 입력</h1>
<form action="inputProc">
<%--    데이터를 받는 공간의 이름(변수명)이 name의 값과 같아야한다--%>
  <input type="text" name="str" placeholder="문자열 입력" ><br>
  <input type="number" name="num" placeholder="숫자열 입력"><br>
  <input type="submit" value="전송">

</form>
</body>
</html>
