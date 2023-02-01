<%--
  Created by IntelliJ IDEA.
  User: window
  Date: 2022-10-25
  Time: 오후 2:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <style>
      div {
          width: 200px;
          height: 200px;
          margin-right: 7px;
          text-align: center;
      }

      #mousezone {
          background-color: #59b1f6;
      }

      #overzone {
          background-color: #ffb5b4;
      }

  </style>
</head>
<body>
<a href="hideshow">이동</a>
<p>클릭 하면 글자 색상이 바뀌어요~!</p>
<p>클릭 하면 글자 색상이 바뀌어요~!</p>
<p>클릭 하면 글자 색상이 바뀌어요~!</p>
<p>클릭 하면 글자 색상이 바뀌어요~!</p>
<div id="mousezone">마우스 존</div>
<div id="overzone">H 오버 존</div>
아이디: <input type="text" name="userid">
<br>
비밀번호: <input type="password" name="userpass">
</body>
<script src="js/jquery-3.6.1.js"></script>
<script>
    $("p").click(function () {
        $(this).css("color", "red");
    });

    $("p").dblclick(function () {
        $(this).css("color", "blue");
    });

    $("#mousezone").mouseenter(function () {
        $(this).text("마우스가 들어옴.");
        $(this).css("backgroundColor", "red");
    });
    $("#mousezone").mouseleave(function () {
        $(this).text("마우스가 나감.");
        $(this).css("backgroundColor", "green");
    })

    $("#mousezone").mousedown(function(){
        $(this).text("마우스 버튼 눌림");
        $(this).css("color", "yellow");
    });
    $("#mousezone").mouseup(function(){
        $(this).text("마우스 버튼 뗌!")
        $(this).css("color", "black")
    })

    $("#overzone").hover(function(){
        $(this).text("마우스가 들어옴.");
        $(this).css("backgroundColor", "red");
    }, function(){
        $(this).text("마우스가 나감.");
        $(this).css("backgroundColor", "green");
    });

    $("input").focus(function(){
       $(this).css("backgroundColor", "#cccccc") ;
    });
    $("input").blur(function(){
        $(this).css("backgroundColor", "#ffffff");
    });
</script>
</html>
