<%--
  Created by IntelliJ IDEA.
  User: window
  Date: 2022-10-27
  Time: 오전 9:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <title>Title</title>
  <style>
      .basic {
          width: 200px;
          height: 150px;
          border: 1px solid;
          text-align: center;
          line-height: 150px;
          margin-top: 20px;
      }

      .change {
          background-color: blue;
      }
  </style>
  <script src="https://code.jquery.com/jquery-3.6.1.min.js"
          integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ="
          crossorigin="anonymous"></script>
  <script>
      $(function () {
          $("#add").click(function () {
              $("div").addClass("change");
          });

          $("#remove").click(function () {
              $("div").removeClass("change");
          });
          $("#toggle").click(function () {
              $("div").toggleClass("change");
          });

          //날짜

          const week = ["일", "월", "화", "수", "목", "금", "토"];

          $("#date").click(function () {
              const now = new Date();

              let d = now.getFullYear() + "년 "
                  + (now.getMonth() + 1) + "월 "
                  + now.getDate() + "일 ("
                  + week[now.getDay()] + ")  "  // 0:일요일, 6:토요일
                  + now.getHours() + ":"
                  + now.getMinutes() + ":"
                  + now.getSeconds();
              $("#np").html(d);
          })
      });
  </script>
</head>

<body>

<button id="add">클래스 추가</button>
<button id="remove">클래스 삭제</button>
<button id="toggle">클래스 토글</button>

<%--클래스를 여러개 작성할 수도 있음(class="basic change")--%>
<div class="basic">DIV</div>

<a href="addRemove">추가삭제로 이동</a>

<hr>
<h2>오늘은?</h2>
<button id="date">Date</button>
<p id="np"></p>
</body>
</html>
