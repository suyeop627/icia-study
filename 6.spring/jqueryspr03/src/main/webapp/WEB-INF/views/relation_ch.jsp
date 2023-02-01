<%--
  Created by IntelliJ IDEA.
  User: window
  Date: 2022-10-27
  Time: 오후 2:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <style>
      .ancestors * {
          display: block;
          border: 2px solid gray;
          color: black;
          padding: 5px;
          margin: 15px;
      }

  </style>
</head>
<body>
<div class="ancestors">
  <div class="parents" style="width:500px;">
    div(.parents)
    <ul>ul
      <li>li
        <span class="first">span</span>
      </li>
    </ul>
  </div>
  <div class="parents" style="width:500px;">
    div(.parents)
    <p>p
      <span class="second">span</span>
    </p>
  </div>
</div>
<button id="child">자식찾기</button>
<button id="find">span 찾기</button>
<button id="find2">자식 전체 찾기</button>
<hr>
<a href="sibling">형제관계</a>
</body>
<script src="https://code.jquery.com/jquery-3.6.1.min.js"
        integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ="
        crossorigin="anonymous">
</script>
<script>
    $("#child").click(function () {
        $(".parents").children().css({
            "color": "red",
            "border": "2px solid red",
        });
    });
    $("#find").click(function () {
        $(".parents").find("span").css({
            "color": "red",
            "border": "2px solid red",
        });
    });
    $("#find2").click(function () {
        $(".parents").find("*").css({
            "color": "red",
            "border": "2px solid red",
        });
    });
</script>

</html>
