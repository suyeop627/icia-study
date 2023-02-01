<%--
  Created by IntelliJ IDEA.
  User: window
  Date: 2022-10-27
  Time: 오후 1:50
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
  <div style="width:500px;">div (great-grandparent)
    <ul>ul (grandparent)
      <li>li (direct parent)
        <span>span</span>
      </li>
    </ul>
  </div>

  <div style="width:500px;">div (grandparent)
    <p>p (direct parent)
      <span>span</span>
    </p>
  </div>
</div>
<button id="parent">부모선택</button>
<button id="parents">상위요소선택</button>
<button id="until">...까지선택</button>
<hr>
<a href="relation_ch">계층찾기</a>
</body>
<script src="https://code.jquery.com/jquery-3.6.1.min.js"
        integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ="
        crossorigin="anonymous">
</script>
<script>
    $("#parent").click(function () {
        $("span").parent().css({    //.parnet().parent()로, 두단계 위의 조상 선택 가능
            "color": "red",
            "border": "2px solid red"
        })
    });
    $("#parents").click(function () {
        $("span").parents().css({
            "color": "red",
            "border": "2px solid red"
        });
    });
    $("#until").click(function(){
        $("span").parentsUntil(".ancestors").css({
            "color": "red",
            "border": "2px solid red"
        });
    })
</script>
</html>
