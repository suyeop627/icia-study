<%--
  Created by IntelliJ IDEA.
  User: window
  Date: 2022-10-27
  Time: 오후 3:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <script src="https://code.jquery.com/jquery-3.6.1.min.js"
          integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ="
          crossorigin="anonymous">
  </script>
  <style>
      .siblings * {
          display: block;
          border: 2px solid #a7a7a7;
          color: #a7a7a7;
          padding: 5px;
          margin: 15px;
      }
  </style>
</head>
<body>
<div class="siblings">div (parent)
  <p>p</p>
  <span>span</span>
  <h2>h2</h2>
  <h3>h3</h3>
  <h4>h4</h4>
  <h5>h5</h5>
  <h6>h6</h6>
  <p>p</p>
</div>
<button id="sib">sibling</button>
<button id="next">next</button>
<button id="nextAll">next all</button>
<button id="nextUntil">next until</button>
<hr>
<a href="filtering">필터링</a>
</body>
<script>
    $("#sib").click(function () {
        //선택자 요소 를 제외한 형제 요소 선택
        $("h2").siblings().css({
            "color":"red",
            "border":"2px solid red"
        })
    });
    $("#next").click(function () {
        $("h2").next().css({
            "color":"red",
            "border":"2px solid red"
        });
    });
$("#nextAll").click(function () {
        $("h2").nextAll().css({
            "color":"red",
            "border":"2px solid red"
        });
    });
$("#nextUntil").click(function () {
        $("h2").nextUntil("h6").css({
            "color":"red",
            "border":"2px solid red"
        });
    });


</script>
</html>
