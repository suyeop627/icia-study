<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var = "now" value="<%=new Date() %>"/>
<%--<fmt:setLocale value="en_US" />--%>
<%--scope="session"--%>


<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<p>default</p>

<h3><fmt:formatDate value="${now}"/></h3>
<p>date |time</p>
<h3><fmt:formatDate value="${now}" type = "time"/></h3>
<h3><fmt:formatDate value="${now}" type = "date" /></h3>
<p>both</p>
<h3><fmt:formatDate value="${now}" type = "both" /></h3>

<p>dateStyle(timeStyle)="full"</p>
<h3><fmt:formatDate value="${now}" type = "date" dateStyle="full"/></h3>
<h3><fmt:formatDate value="${now}" type = "time" timeStyle="full"/></h3>

<p>dateStyle(timeStyle)="long"</p>
<h3><fmt:formatDate value="${now}" type = "date" dateStyle="long"/></h3>
<h3><fmt:formatDate value="${now}" type = "time" timeStyle="long"/></h3>

<p>dateStyle(timeStyle)="medium"</p>
<h3><fmt:formatDate value="${now}" type = "date" dateStyle="medium"/></h3>
<h3><fmt:formatDate value="${now}" type = "time" timeStyle="medium"/></h3>

<p>dateStyle(timeStyle)="short"</p>
<h3><fmt:formatDate value="${now}" type = "date" dateStyle="short"/></h3>
<h3><fmt:formatDate value="${now}" type = "time" timeStyle="short"/></h3>

<p>pattenr ="출력형식"</p>
<h3><fmt:formatDate value="${now}" type="date" pattern="yyyy년 MM월 dd일(E)"/></h3>
<h3><fmt:formatDate value="${now}" type="time" pattern="[a] HH:mm:ss"/></h3>


<hr>
<h2>숫자 형식 지정</h2>
<fmt:formatNumber value="1234567" groupingUsed="true"/><br>
<%--출력할 자릿수가 더 많을 경우, 표기할 자릿수 처리(자릿수가 적다고해서 더 채워주진 않는다.. 반올림된 수를 출력함.--%>
<fmt:formatNumber value="3.123123" pattern = "#.##"/><br>
<%--지정한 형식보다 많을 경우엔 반올림해서 해당 자릿수만큼 출력하고, 자릿수가 부족할 경우, 지정한 숫자를 채워서 출력한다.--%>
<fmt:formatNumber value="1.5" pattern="#.000"/><br>


<%--%로 변환--%>
<fmt:formatNumber value="0.45" type="percent"/><br>
<%--지역 정보를 참조하여 해당 국가의 통화기호로 표기--%>
<fmt:formatNumber value="1000000" type="currency"/><br>
<%--통화 기호 직접 작성--%>
<fmt:formatNumber value="1000000" type="currency" currencySymbol="$"/><br>



<%--
  Created by IntelliJ IDEA.
  User: window
  Date: 2022-10-20
  Time: 오전 9:41
  To change this template use File | Settings | File Templates.
--%>

<%--<%--%>

<%--/*--%>
<%--    자바 코드로 날짜 처리--%>
<%--      Date now = new Date();--%>
<%--    SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");--%>
<%--    String nowdate = sdf.format(now);--%>
<%--    out.print("<h3>" + nowdate + "</h3>" ); //내장 객체 out을 활용해서 브라우저에 출력 할 수도 있다. out 객체 : 브라우저에 출력하는 객체 / System.out.print와 같은 효과--%>
<%--    <h3><%=nowdate%></h3>--%>
<%--*/--%>


<%--%>--%>

