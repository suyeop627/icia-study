<%--
  Created by IntelliJ IDEA.
  User: window
  Date: 2022-10-20
  Time: 오전 10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- jstl로 변수 생성--%>
<c:set var="num1" value="11"/>
<c:set var="num2" value="4"/>
<c:set var="res" value="${num1 * num2}"/>
<c:set var="id" value="user"/>


<html>
<head>
    <title>JSTL home</title>
</head>
<body>

${num1} * ${num2} = ${res}

<hr>
<p>if 활용</p>



<%--test에 조건 넣기--%>
<c:if test="${empty id}">
    <p>안녕하세요. Guest님 </p>
</c:if>
<%--첫 if문이 아닐 경우 실행할 문장을 새로운 if로 작성.(else문이 존재하지 않는다.)--%>
<c:if test="${!empty id}">
    <p>안녕하세요. ${id}님</p>
</c:if>
<hr>
<p>choose 활용</p>



<c:set var="sel" value="1"/>
<%--<c:choose> 영역 선언--%>
<c:choose>
<%--when 각 조건 설정(if문처럼, 각 when이 분기 조건을 설정함)--%>
    <c:when test="${sel == 0}">
        <p>처음 뵙겠습니다.</p>
    </c:when>
    <c:when test="${sel>0}">
        <p>반갑습니다.</p>
    </c:when>
<%--when으로 정한 조건 외의 경우--%>
    <c:otherwise>
        <p>안녕하세요</p>
    </c:otherwise>

</c:choose>

<hr>
<p>forEach 활용</p>
<%--var 카운팅, begin 시작, end 끝. step 카운팅하는 숫자의 증감폭--%>
<%--forEach는 시작과 끝을 정해놓고 반복하므로, 무한반복은 불가능하다.--%>
<c:forEach var="cnt" begin="1" end="5" step="2">
<%--    cnt에 따라 글자 크기가 커지도록.(font 태그의 사용은 권장하지 않는다.)--%>
    <font size = "${cnt}">야호~~~</font><br>
</c:forEach>


<hr>
<a href = "include">[오늘의 메뉴]</a>



</body>
<script>
let n = ${res};
alert(n)
</script>
</html>
