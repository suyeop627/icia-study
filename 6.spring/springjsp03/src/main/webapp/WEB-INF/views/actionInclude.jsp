<%--
  Created by IntelliJ IDEA.
  User: window
  Date: 2022-10-20
  Time: 오전 9:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>Title</title>
</head>
<body>
<h1>오늘의 메뉴</h1>
<div>
  <ul>
    <%--    목록같은 것을 받아서 반복할 땐, begin end가 아니라, items로 처리한다.--%>
    <c:forEach var="m" items="${menu}" varStatus="status">

      <c:if test="${status.first}">
        <li><b>${status.index} - ${status.count} : ${m}</b></li>
      </c:if>

      <c:if test= "${status.count % 2==0}">
        <li><span style ="color : blue">${status.index} - ${status.count} : ${m}</span></li>
      </c:if>

      <c:if test= "${status.count % 2!=0}">
        <li>${status.index} - ${status.count} : ${m}</li>
      </c:if>

      <c:if test="${!status.first}">
       <li> <b>${status.index} - ${status.count} : ${m}</b></li>
      </c:if>

    </c:forEach>
  </ul>
</div>
<hr>

<%--<%@ include file="today.jsp" %>--%>
<%--<hr>--%>
<%--<jsp:include page="today.jsp"/>--%>
<%--<hr>--%>
<c:import url="today.jsp"/>
</body>
</html>
