<%--
  Created by IntelliJ IDEA.
  User: window
  Date: 2022-10-31
  Time: 오후 1:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>수정 양식</title>
</head>
<body>
<h1>데이터 수정</h1>
<fieldset>
<%--  수정 요청이 들어오면 DB먼저 거쳐서 데이터를 가져온 후 화면이 출력됨--%>
  <legend>변경할 데이터를 입력하세요.</legend>
  <form action="updateProc">
    <%-- 각 초기값을 화면에 보여주기 위해 value를 추가.(inputFrm.jsp와 다른점)--%>
    <%--    input의 속성 중, readonly는 form 전송이 되지만, disabled는 전송이 되지 않는다.--%>
    <p>코드 : <input type="text" name="m_code" value="${data.m_code}" readonly></p>
    <p>문자열 : <input type="text" name="m_str" value = ${data.m_str}}></p>
    <p>정수 : <input type="number" name="m_int" value = ${data.m_int}></p>
    <p>날짜 : <input type="date" name="m_date" value = ${data.m_date}></p>

    <input type="submit" value="전송">
  </form>
</fieldset>
</body>
<script>
    let m = "${msg}";
    if(m!=""){
        alert(m);
    }
</script>
</html>
