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
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<h1>시작 페이지</h1>
<p>환영합니다</p>
<p>JSP로 만든 페이지 입니다.</p>
<a href="mp">[내 페이지]</a> <%--a태그는 GetMapping만 가능하다.--%>
<a href="hobby">[내 취미]</a><br/>
<a href="inputFrm">[입력화면]</a>
<a href="joinFrm">[회원 가입]</a><br/>
<a href="output">[출력화면]</a>

<hr>
<%--이미지 자료도 서버를 한번 거쳐서 출력이 되도록해야하는데, application properties에 경로를 설정하고, static 폴더에 해당 자료를 넣으면 된다.--%>
<%--spring.web.resources.static-locations=classpath:static/--%>
<img src ="images/cake.jpg" width="500">
</body>
</html>
