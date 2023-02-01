<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.jsframe.springjsp02.dto.CalDto" %><%--page 지시자로 import문 삽입--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
  Date now = new Date();
  SimpleDateFormat sdf = new SimpleDateFormat("(a) hh:mm:ss");

  String nowTime = sdf.format(now);

  //직접 만든 클래스를 사용할 수도 있다.
  CalDto cd = new CalDto();
  cd.setNum1(5);
%>
<h1>현재 시간</h1>
<h2><%=nowTime%></h2>

</body>
</html>
