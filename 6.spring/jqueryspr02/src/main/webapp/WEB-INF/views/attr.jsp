<%--
  Created by IntelliJ IDEA.
  User: window
  Date: 2022-10-26
  Time: 오후 1:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>jQuery 속성 처리</title>
  <script src="https://code.jquery.com/jquery-3.6.1.min.js"
          integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ="
          crossorigin="anonymous">
  </script>
  <script>
      $(function () {
          let txt = $("p").text();
          let html = $("p").html();
          console.log("txt : " + txt, "\nhtml : " + html);

          $("#text").text("<h2>text와 html의 차이<h2>");
          $("#html").html("<h2>text와 html의 차이<h2>");
          let type = $("#intag").attr("type");
          console.log(type);
          $("#inbtn").click(function () {
              let indata = $("#intag").val();
              console.log(indata);
          });
          $("#chbtn").click(function () {
              $("#intag").attr("type", "button");
              $("#intag").val("버튼임.");
          });


          //범위 입력 처리
          let i = $("#point").val();

          //현재값 출력
          //change 메서드 사용(슬라이드바를 다 움직이고 나서 값 출력)
          /*
          $("#point").change(function () { //input의 type이 select나 range 등은 값 변경에 대한 처리에 change 메서드 사용한다
              let val = $(this).val();
              i = val;
              console.log(i);
              $("#msg").html(val);
          });
          */


          //on 메서드 사용(슬라이드바를 움직이는 동안 실시간으로 값 변경)
          $("#point").on("input", function () {
              let val = $(this).val();
              i = val;
              console.log(i);
              $("#msg").html(val);
          });



          //증가 버튼
          $("#inc").click(function(){
              i++;
              $("#msg").val(i);
              $("#msg").html(i);
          });
          //감소버튼
          $("#dec").click(function(){
              i--;
              $("#msg").val(i);
              $("#msg").html(i);
          })
      });
  </script>
</head>
<body>

<h2>속성 읽기(내용은 콘솔에서 확인)</h2>
<p>문자가 쓰여진 <b>강조된</b> 영역</p>
<span id="text"></span>
<span id="html"></span>
<input id="intag" type="text" value="text">
<button id="inbtn">값읽기</button>
<button id="chbtn">속성 변경</button>

<hr>
<fieldset>
  <legend>숫자 입력</legend>
  범위(1~100) : <input id="point" type="range" min="0" max="100" value="30" step="1">
  현재 값 : <span id="msg"></span><br>
  <button id="inc">증가</button>
  <button id="dec">감소</button>

</fieldset>


</body>
</html>
