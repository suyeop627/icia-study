<%--
  Created by IntelliJ IDEA.
  User: window
  Date: 2022-10-31
  Time: 오후 3:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Data List</title>
</head>
<body>
<h1>데이터 목록</h1>
<table border="1">
  <tr>
    <th width="50">코드</th>
    <th width="100">문자열</th>
    <th width="80">정수</th>
    <th width="100">날짜</thwidth>
  </tr>
  <c:forEach var="d" items="${dList}">
<tr>
  <td>${d.m_code}</td>
  <td>${d.m_str}</td>
  <td>${d.m_int}</td>
  <td>${d.m_date}</td>
</tr>
  </c:forEach>
</table>
</body>
</html>
