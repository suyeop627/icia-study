<%--
  Created by IntelliJ IDEA.
  User: window
  Date: 2022-10-25
  Time: 오전 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <script src="js/jquery-3.6.1.js"></script>
  <%-- 외부 스크립트 파일의 url을 적는 태그사이에는 다른 문장을 적지 않는다.
  따로 script태그 만들어서 그 안에 작성해야함.
  또한, url을 적는 <script>는 실행문보다 위에 작성한다--%>
  <%--  페이지소스보기-> script url클릭-> 해당 코드가 나와야 정상.--%>
  <script>
      $("document").ready(function () {
          $("button").click(() => {
              alert("버튼이 눌렸네요.");
              $("#out").html("버튼으로 추가한 문장.")
          });

          $(":button").click(function () {
              //location.href = "jquery01";
              location.href = "event";
          })
      });//ready end
  </script>
</head>
<body>
<h1>jQeury first ~ </h1>
<button>실행</button>
<input type="button" value="이동">
<p id="out"></p>
</body>
</html>
