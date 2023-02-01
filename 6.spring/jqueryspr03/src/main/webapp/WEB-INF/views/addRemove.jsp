<%--
  Created by IntelliJ IDEA.
  User: window
  Date: 2022-10-27
  Time: 오전 10:05
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
    .colorBlue{
        color:blue;
    }
    .parent{
        background-color: yellow;
        width:400px;
        height: 180px;
        text-align: center;
    }
    .c1{
        background-color: blue;
        width:300px;
        height:50px;
        margin:20px auto;
    }
  .c2{
        background-color: green;
        width:300px;
        height:50px;
        margin:20px auto;
    }

  </style>
</head>
<body>
<h2>요소 추가</h2>
<button id="apnd">Append</button>
<button id="ppnd">Prepend</button>
<button id ="bef">Before</button>
<button id ="aft">After</button>
<ol>
  <li>List Item 1</li>
</ol>

<hr>
<h2>요소 삭제</h2>
<div class="parent">
  <b>부모 요소 </b>
  <div class="c1">자식요소 1</div>
  <div class="c2">자식요소 2</div>
</div>
<button id="remove">Remove</button>
<button id="empty">Empty</button>
<hr>
<a href="guest">방명록이동</a>
<a href="relation">계층관계로 이동</a>

</body>
<script>
    //요소 추가
  let i = 1;
  $("#apnd").click(function(){
     i++;
      $("ol").append("<li>List Item(append) " + i + "</li>");
  });
  $("#ppnd").click(function () {
      i++;
      $("ol").prepend("<li class='colorBlue'>List Item(prepend)" + i + "</li>");
  });
  $("#bef").click(function(){
      i++;
      $("ol").before("<p>paragraph(before)" + i + "</p>");
  });
$("#aft").click(function(){
    i++;
      $("ol").after("<p class='colorBlue'>paragraph(after)" + i + "</p>");
  });



//요소 삭제
    $("#remove").click(() => {
        $(".parent").remove();//자식요소를 포함하여, 선택된 요소 삭제
    });
    $("#empty").click(() => {
        $(".parent").empty();//선택된 요소의 자식요소만 삭제
    });
</script>
</html>
