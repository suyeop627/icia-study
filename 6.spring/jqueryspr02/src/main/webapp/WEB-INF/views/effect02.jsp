<%--
  Created by IntelliJ IDEA.
  User: window
  Date: 2022-10-26
  Time: 오전 8:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Fade In & Out</title>
  <%--cdn으로 원하는 버전 받고, 라이브러리 다운로드까지해야 함.--%>
  <script src="https://code.jquery.com/jquery-3.6.1.min.js"
          integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ="
          crossorigin="anonymous"></script>
  <script>
      $(function () {
          //fade IN
          $("#vs").click(() => {
              //.first() : 같은 요소 중 첫번째 요소를 선택하는 함수
              $("div").first().fadeIn("slow", function () {
                  //this : 첫번째 div | .next() : 선택된 요소의 다음 요소를 선택하는 함수
                  $(this).next("div").fadeIn("slow", function () {
                      $(this).next("div").fadeIn("slow");
                  });
              });
          });

          //fade out
          $("#iv").click(() => {
              //.last() : 같은 요소 중 마지막 요소를 선택하는 함수
              $("div").last().fadeOut("slow", function () {
                  //this : 마지막 div | .prev() : 선택된 요소의 이전 요소를 선택하는 함수
                  $(this).prev("div").fadeOut("slow", function () {
                      $(this).prev("div").fadeOut("slow");
                  });
              });
          });


          //toggle
          $("#to").click(() => {
              //.first() : 같은 요소 중 첫번째 요소를 선택하는 함수
              $("div").first().toggle("slow", function () {
                  //this : 첫번째 div | .next() : 선택된 요소의 다음 요소를 선택하는 함수
                  $(this).next("div").toggle("slow", function () {
                      $(this).next("div").toggle("slow");
                  });
              });
          });

          //fade to
          $("#ft").click(() => {
              //opacity 를 0으로 하면 visibility hidden 과 같은 효과
              $("#d1").fadeTo("slow", 0.15);
              $("#d2").fadeTo("slow", 0.4);
              $("#d3").fadeTo("slow", 0.7);
          });


          //slide
          /* $("#flip1").click(function(){
              $(this).next().slideDown("slow");
           });*/
          $("#flip1").click(function () {
              $(this).next().slideToggle("slow");
          });

          $("#flip2").click(function () {
              $(this).prev().slideUp("slow");
          })

          //animate
          $("#ani").click(function () {
              $("#ad").animate({
                  left: "250px",
                  opacity: "0.5",
                  height: "150px",
                  width: "150px"
              }, "slow", function () {
                  alert("에니메이션 완료");
              });
          });

      });
  </script>
  <style>
      div#d1, div#d2, div#d3 {
          width: 80px;
          height: 80px;
          display: none; /*   display : none; 요소의 자리까지 지움*/
          /*  visibility : hidden; /*<-요소의 자리는 남겨둠*/
      }

      #flip1, #flip2, #panel {
          padding: 5px;
          text-align: center;
          background-color: #cccccc;
          border: solid 1px;

      }

      #panel {
          padding: 50px;
          display: none;
      }

      #flip1, #flip2 {
          cursor: pointer;
      }

      #ad {
          background-color: #98bf21;
          height: 100px;
          width: 100px;
          position: absolute;
      }

  </style>

</head>
<body>
<a href="attr">속성으로 이동</a>

<h1>Fade 효과</h1>

<button id="vs">Fade In</button>
<button id="iv">Fade Out</button>
<button id="to">Fade Toggle</button>
<button id="ft">Fade To</button>

<div id="d1" style="background-color:red"></div>
<div id="d2" style="background-color:green"></div>
<div id="d3" style="background-color:blue"></div>

<hr>

<h2>Slide 효과</h2>
<div id="flip1">click to open submenu</div>
<div id="panel">submenu</div>
<div id="flip2">click to close submenu</div>

<hr>

<h2>Animate 효과</h2>
<button id="ani">Animate</button>
<div id="ad"></div>


</body>
</html>
