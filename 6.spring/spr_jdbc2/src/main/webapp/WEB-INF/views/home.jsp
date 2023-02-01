<%--
  Created by IntelliJ IDEA.
  User: window
  Date: 2022-10-31
  Time: 오후 1:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>데이터 관리자</title>
</head>
<body>
<h1>데이터 관리자</h1>
<p>
  <a href="inputFrm">[데이터 입력]</a> |
  <a href="dataList">[데이터 목록]</a> |
</p>
<hr>
<p>${nowTime}</p>
</body>
<script>
    //RedirectAttributes 에 저장된 값도 el로 사용가능
  let m = "${msg}";
  if(m!=""){
      alert(m);
  }
</script>
</html>
