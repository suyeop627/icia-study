<%--
  Created by IntelliJ IDEA.
  User: window
  Date: 2022-10-18
  Time: PM 3:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>출력화면</title>
</head>
<body>
<p>data 1 : ${data1}</p>
<p>data 2 : ${data2}</p>
<p>msg : ${msg}</p>

<hr>
<h1>회원정보</h1>
<p>아이디 : ${mem.id}</p>
<p>비밀번호 : ${mem.pwd}</p>
<p>이름 : ${mem.name}</p>
<p>나이 : ${mem.age}</p>

</body>
<script>
    //자바스크립트에서도 데이터를 받아 처리할 수 있음.
    let message = '${msg}';
    alert(message);
</script>
</html>
