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
  <title>입력 양식</title>
</head>
<body>
<h1>데이터 입력</h1>
<fieldset>
  <legend>다음 데이터를 입력하세요.</legend>
  <form action="inputProc">
<%--   name의 값을 dto의 변수명(db의 컬렴명)과 동일하게 작성한다. --%>
  <p>문자열 : <input type="text" name="m_str"></p>
  <p>정수 : <input type="number" name="m_int"></p>
  <p>날짜 : <input type="date" name="m_date"></p>
    <input type="submit" value="전송">
  </form>
</fieldset>
</body>
</html>
