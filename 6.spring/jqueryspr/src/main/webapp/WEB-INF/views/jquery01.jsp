<%--
  Created by IntelliJ IDEA.
  User: window
  Date: 2022-10-25
  Time: 오후 1:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<h1>jQeury selector</h1>
<hr>
<h2>클래스가 없는 요소</h2>
<h2 class="cls">클래스가 있는 요소</h2>
<h2>클래스가 없는 요소</h2>
<h3 class="cls"> 클래스가 있는 요소</h3>
<button id="classSel">클래스선택</button>

</body>
<script src="js/jquery-3.6.1.js"></script>
<script>
    $("#classSel").click(function(){
        $(".cls").css("backgroundColor", "red");
        $(".cls").css("color", "yellow");
        $(this).hide();
        setTimeout(function (){
            turnBack();
        }, 3000);
    });

    function turnBack() {
        $("*").show();
    }

</script>
</html>
