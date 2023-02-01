<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Main</title>
  <link rel="stylesheet" href="css/Style_login.css">
  <link rel="stylesheet" href="css/Style.css">
</head>
<body>
<div class="helloId">
  <h1 id="title">Member Manager</h1>
  <b>${mem.m_name}님</b>
  <a href="logoutProc">로그아웃</a>
  <a href="resignProc">회원탈퇴</a><%--  데이터 삭제--%>
</div>
<center>
  <div class="login">

    <div class="login-screen">
      <div class="app-title">
        <h6>회원 정보</h6>
      </div>
      <div class="login-form">
        <form action="updateProc" method="post">
          <div class="control-group">
            <input id="m_id" type="text" name="m_id" class="login-field" value="${mem.m_id}" readonly>
            <!-- 수정 못하게 readonly-->
          </div>
          <div class="control-group">
            <input type="text" name="m_name" class="login-field" value="${mem.m_name}" required>
            <!-- 지우고 안보낼수도 있으니 readonly-->
          </div>
          <div class="control-group">
            <input type="date" name="m_date" class="login-field" value="${mem.m_birth}">
          </div>
          <div class="control-group">
            <input type="text" name="m_phone" class="login-field" value="${mem.m_phone}">
          </div>
          <input type="submit" value="수정" class="btn">
          <a href="/" class="login-link">돌아가기</a>
        </form>
      </div>
    </div>
  </div>
</center>


</body>
<script>
    let loginSuc = "${mem.m_id}";
    if (loginSuc == "") {
        //로그인을 안 한 경우 로그인 페이지로 이동.
        location.href = "/";
    }
    let m = "${msg}"
    if (m != "") {
        alert(m);
    }
</script>
</html>
