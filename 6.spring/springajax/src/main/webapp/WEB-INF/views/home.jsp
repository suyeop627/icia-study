<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <script src="js/jquery-3.6.1.min.js"></script>
</head>
<body>
<h2>일반 컨트롤러와 데이터 주고 받기</h2>
<p>id : <input id="inId" type="text" placeholder="ID를 입력하세요."></p>
<p>
  <button id="idCheck">중복확인</button>
  <button id="restCheck">중복확인(REST)</button>
</p>
<p>PWD : <input id="inPwd" type="password" placeholder="비밀번호를 입력하세요"></p>
<p>name : <input id="inName" type="text" placeholder="이름를 입력하세요"></p>
<p>
  <button id="send1">가입1</button>
</p>
<%--form활용--%>
<h2>다시 만든 입력 양식</h2>
<form id="joinFrm">
  <%--dto에 작성한 변수명과 일치하도록 name의 속성값 작성--%>
  <p>id : <input name="m_id" type="text" placeholder="ID를 입력하세요."></p>
  <p>PWD : <input name="m_pwd" type="password" placeholder="비밀번호를 입력하세요"></p>
  <p>name : <input name="m_name" type="text" placeholder="이름를 입력하세요"></p>
  <p>
    <button type="button" id="send2">가입2</button>
  </p>
</form>
</body>
<script>

    //@Controller를 사용한 통신
    $("#idCheck").click(function () {
        let idvalue = $("#inId").val();
        let sendObj = {"data": idvalue};

        //컨트롤러와 통신
        $.ajax({
            url: "idcheck",
            type: "get",
            data: sendObj,
            success: function (result) {
                if (result == "ok") {
                    alert("사용 가능한아이디 입니다.");
                } else {
                    alert("이미 사용중인 아이디 입니다.")
                }
            },
            error: function (error) {
                alert("전송 실패");
                console.log(error);
            }
        });
    });

    //@RestController를 사용한 통신
    $("#restCheck").click(function () {
        let idval = $("#inId").val();
        let sObj = {"idv": idval};
        $.ajax({
            url: "restcheck",
            type: "post",
            data: sObj,
            success: function (result) {
                alert(result);
            },
            error: function (error) {
                alert("전송실패");
                console.log(error);
            }
        });
    });

//dto를 사용한 전송
    $("#send1").click(function () {
        let id = $("#inId").val();
        let pwd = $("#inPwd").val();
        let name = $("#inName").val();

        let sData = {
            "m_id": id,
            "m_pwd": pwd,
            "m_name": name
        }

        $.ajax({
            url: "joinProc",
            type: "post",

            data: sData,
            success: function (r) {
                alert(r);
            }
            ,
            erorr: function (e) {
                alert("전송실패")
                console.log(e)
            }
        })
    });


    //form으로 묶어서 전송하는 방식
    $("#send2").click(function () {
        const formData = $("#joinFrm").serialize();//직렬화 +)serial 직렬 , parallel병렬
        //병렬화되어 쌓여있는 input태그들의 값들을 직렬화 시켜서 전송하기 위한 메서드
        //console.log(formData);
        $.ajax({
            url: "joinProc",
            type: "post",
            data: formData,
            success: function (result) {
                alert(result);
            },
            error: function (error) {
                alert("전송실패");
                console.log(error);
            }
        });
    });

</script>
</html>
