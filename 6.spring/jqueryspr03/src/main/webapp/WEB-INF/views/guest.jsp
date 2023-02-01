<%--
  Created by IntelliJ IDEA.
  User: window
  Date: 2022-10-27
  Time: 오전 10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <style>
      .cont {
          height: 80px;
          line-height: 50px;
          box-sizing: border-box;
          display: flex;
          justify-content: center;
          align-items: center;

      }

      .sub {
          height: 50px;
          border: 1px solid gray;
          box-sizing: border-box;
          width: 100px;
          text-align: center;

      }

      .ct {
          width: 200px;
      }

      .date {
          width: 150px;
      }
  </style>
  <script src="https://code.jquery.com/jquery-3.6.1.min.js"
          integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ="
          crossorigin="anonymous">
  </script>
  <script>

      $(function () {
          $("#inbtn").click(() => {
              //입력한 작성자와 내용을 가져오기
              let name = $("#name").val();
              let content = $("#content").val();

              //날짜와 시간 문자열 생성
              const now = new Date();
              let d = now.getFullYear() + "-"
                  + (now.getMonth() + 1) + "-"
                  + now.getDate() + "-"
                  + String(now.getHours()).padStart(2, "0") + ":"
                  + String(now.getMinutes()).padStart(2, "0");

              let tag = "<div class='cont'>" +
                  "<div class='sub'>" + name + "</div>" +
                  "<div class ='sub ct'>" + content + "</div>" +
                  "<div class ='sub date'>" + d + "</div>" +
                  "<button class='del'>삭제</button>" +
                  "</div>";
              $("#book").prepend(tag);
          });
          $(document).on("click", ".del", function () {
              let conf = confirm("정말 삭제하시겠습니까?")
              if (conf === true) {
                  $(this).parent().remove();
              }
          });
      });

  </script>
</head>
<body>
<h1>방명록</h1>
<h2>방문을 환영합니다.</h2>
<fieldset>
  <legend>아래에 글을 남겨주세요.</legend>
  <table>
    <tr>
      <td>
        작성자 :
      </td>
      <td>
        <input type="text" id="name"/>
      </td>
    </tr>
    <tr>
      <td>
        내용 &nbsp;&nbsp; :
      </td>
      <td>
        <input type="text" id="content"></p>
      </td>
    </tr>

  </table>
  <button id="inbtn">작성</button>
  <div id="book">
    <%--여기에 새로운 글이 추가됩니다.--%>
  </div>

</fieldset>
</body>
</html>
