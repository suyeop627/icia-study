<%--
  Created by IntelliJ IDEA.
  User: window
  Date: 2022-10-25
  Time: 오후 3:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Hide & show</title>
  <style>
    div{
        background-color: green;
        width: 100px;
        padding: 10px 0; /*2개 작성시 top&bottom left&right*/
                          /* 4개 작성시 top bottom left right*/
        text-align: center;
    }
  </style>
  <script src="js/jquery-3.6.1.js"></script>
  <script>
    $(function(){//ready 함수의 약식 표현
      $("ul").hide();

      $("div").hover(function () {
          //마우스가 들어갔을 때
          $("ul").show(1000);
      }, function () {
          //마우스가 나갔을 때
          $("ul").hide(1000);
      });

    $("#onOff").click(function(){
        let view = $("p").css("display");
        console.log(view)
        if(view=="none"){//p 태그들이 안보인다면
            $("p").css("display", "block");
            //$("p").show();

            $("#onOff").text("Off")
        }else{
            $("p").css("display","none");
            //$("p").hide();
            $("#onOff").text("On")
        }
    })


        $("#toggle").click(function(){
            $("p").toggle(1000, function(){
                let t = $("#toggle").text();
                if(t=="토글오프"){//토글 늦게나옴
                    $("#toggle").text("토글온");
                }
                else{
                    $("#toggle").text("토글오프");
                }
            });
        })



    });//ready end
  </script>
</head>
<body>

<div>메뉴1</div>
<ul>
  <li>LIST 01</li>
  <li>LIST 02</li>
  <li>LIST 03</li>
  <li>LIST 04</li>
  <li>LIST 05</li>
</ul>
<button id="toggle">토글오프</button>
<button id="onOff">OFF</button>
<p>LIST 01</p>
<p>LIST 02</p>
<p>LIST 03</p>
<p>LIST 04</p>
<p>LIST 05</p>
</body>
</html>
