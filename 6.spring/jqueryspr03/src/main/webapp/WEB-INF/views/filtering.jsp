<%--
  Created by IntelliJ IDEA.
  User: window
  Date: 2022-10-27
  Time: 오후 3:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>선택 필터링</title>
  <script src="https://code.jquery.com/jquery-3.6.1.min.js"
          integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ="
          crossorigin="anonymous">
  </script>
</head>
<body>
<div style="border: 1px solid black;">
  <p>첫번째 div 엘리먼트</p>
  <p class="sel">두번째 div 엘리먼트</p>
  <p>세번째 div 엘리먼트</p>
  <p class="sel">네번째 div 엘리먼트</p>
</div>
<br>
<div style="border: 1px solid black;">
  <p>다섯번째 div 엘리먼트</p>
  <p class="sel">여섯번째 div 엘리먼트</p>
  <p>일곱번째 div 엘리먼트</p>
  <p class="sel">여덟번째 div 엘리먼트</p>
</div>
<button id="first">first</button>
<button id="last">last</button>
<button id="eq">eq(2)</button>
<button id="filter">filter</button>
<button id="not">not</button>
</body>
<script>
    $("#first").click(function () {
        $("p").first().css("background-color", "yellow");//계층에 상관없이, 모든 p요소들 중에 첫 p를 찾는다.
    });
    $("#last").click(function () {
        $("p").last().css("background-color","yellow"); //계층에 상관없이, 모든 p요소들 중에 마지막 p를 찾는다.
    });

    $("#eq").click(() => {
        $("p").eq(2).css("background-color", "yellow"); //index 2 : 세번재 p 선택
    });
    $("#filter").click(()=>{
        $("p").filter(".sel").css("background-color", "yellow");  //클래스 sel을 가진 p 선택
    });
    $("#not").click(()=>{
        $("p").not(".sel").css("background-color", "yellow"); //클래스 sel을 가진 p를 제외
    });

</script>
</html>
