<%--
  Created by IntelliJ IDEA.
  User: window
  Date: 2022-10-19
  Time: AM 9:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Js Framework Home</title>
</head>
<body>
<h1>초간단 계산기</h1>
<form action="calProc"> <%-- post를 사용하는 경우 : 숨겨야 하는 데이터(패스워드나 주민번호 등 보완관련 데이터 또는 전송할 내용이 매우 길경우 post방식을 선택하여 전송한다.)   --%>
    <P>값 : 1 <input type="number" name="num1"></P>
    <%--    dto를 만들 때, form의 input의 name과 같은 변수명을 사용한다.--%>
    <p>값 : 2 <input type="number" name="num2"></p>
    <p>
        <%--        form 태그 내부의 버튼은 type="button"을 지정하지 않을 경우, submit의 역할을 한다.--%>

        <button type="button">+</button>
        <button type="button">-</button>
        <button type="button">*</button>
        <button type="button">/</button>
        <button type="button">%</button>

    </p>
    <%-- input에서 value에 있는 값이 넘어가는데, 타입이 submit인 input태그와 button 인 input 태그는 그 value를 전송하지 않는다.--%>
    <%-- 버튼이 눌렸을때 해당 value를 전송하기 위해서 숨겨진 input을 하나 만들어서 그 값을 받아오는 형태로 작성.--%>
    <input type="hidden" name="op" id="op">
    <p><input type="submit" value="전송"></p>
</form>


<hr>

<a href = "dateProc">[오늘의 날짜]</a>
<a href = "oldjsp">[지시자 활용]</a>
<a href = "elop">[EL활용]</a>


</body>
<script>
    //연산 버튼 가져오기.
    const btns = document.getElementsByTagName("button");
    console.log(btns);
    const opInput = document.getElementById("op");

    //각 버튼 처리
    btns[0].addEventListener("click", function () {
        opInput.value = "+";
    })
    btns[1].addEventListener("click", function () {
        opInput.value = "-";
    })
    btns[2].addEventListener("click", function () {
        opInput.value = "*";
    })
    btns[3].addEventListener("click", function () {
        opInput.value = "/";
    })
    btns[4].addEventListener("click", function () {
        opInput.value = "%";
    })


</script>
</html>
