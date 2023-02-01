<%--
  Created by IntelliJ IDEA.
  User: window
  Date: 2022-11-01
  Time: 오전 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>상세보기</title>
</head>
<body>
<h1>데이터 상세보기</h1>
<table border="1">
  <tr>
    <th width="50">CODE</th>
    <%--    dto가 넘어오므로, data라는 변수명으로 사용--%>
    <td>${data.m_code}</td>
  </tr>
  <tr>
    <th>STR</th>
    <td>${data.m_str}</td>
  </tr>
  <tr>
    <th>INT</th>
    <td>${data.m_int}</td>
  </tr>
  <tr>
    <th>DATE</th>
    <td>${data.m_date}</td>
  </tr>
  <tr>
    <td colspan="2">
      <button>수정</button>
      <button>삭제</button>
    </td>
  </tr>
</table>
</body>
<script>
    //수정 버튼 처리
    const ub = document.getElementsByTagName("button");
    ub[0].addEventListener("click", () => {
        location.href = "updateFrm?code=${data.m_code}";
    });
    //삭제 버튼 처리
    ub[1].addEventListener("click", () => {
        let q = confirm("삭제하시겠습니까?");
        if (q == true) {
            location.href = "deleteProc?code=${data.m_code}";
        }
        else{
            alert("삭제를 취소합니다.")
        }
    });

    let m = "${msg}";
    if (m != "") {
        alert(m);
    }

</script>
</html>
