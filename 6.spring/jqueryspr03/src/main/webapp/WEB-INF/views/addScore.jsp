<%--
  Created by IntelliJ IDEA.
  User: window
  Date: 2022-10-27
  Time: 오후 3:56
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
      table {
          border: 3px solid;
          border-collapse: collapse;
      }

      .delete {
          cursor: pointer;
      }

      td {
          width: 200px;
          height: 50px;
          border: 1px solid black;
          text-align: center;
          font-size: 20px;
      }

      input {
          width: 200px;
      }

      select {
          width: 200px;
      }
  </style>
</head>
<body>
학번 : <input type="text" id="no" required><br>
이름 : <input type="text" id="name" required><br>
과목 :
<select id="subject">
  <option value="">선택</option>
  <option value="국어">국어</option>
  <option value="수학">수학</option>
  <option value="영어">영어</option>
  <option value="과학">과학</option>
  <option value="사회">사회</option>
</select>
<br>
점수 : <input type="number" id="score" required><br>
<%--학점 : <input type="text" id="grade"><br>--%>
<button id="insert">입력</button>
<hr>
<table>
  <tr>
    <td>학번</td>
    <td>이름</td>
    <td>과목</td>
    <td>점수</td>
    <td>학점</td>
  </tr>

</table>
</body>
<script>
    $("#insert").click(() => {

        let no = $("#no").val();
        let name = $("#name").val();
        let subject = $("#subject").val();
        let score = $("#score").val();
        let grade;

        if (no === "" || name === "" || subject === "" || score === "") {
            alert("모든 값을 입력하세요.")
        } else if (score > 100 || score < 0) {
            alert("올바른 점수를 입력하세요.")
        } else {
            if (score >= 90) {
                grade = "A";
            } else if (score >= 80) {
                grade = "B";
            } else if (score >= 70) {
                grade = "C";
            } else if (score >= 60) {
                grade = "D";
            } else {
                grade = "F";
            }

            let dataToInsert = "<tr class='delete''>" +
                "<td>" + no + "</td> " +
                "<td>" + name + "</td> " +
                "<td>" + subject + "</td> " +
                "<td>" + score + "</td> " +
                "<td>" + grade + "</td> " +
                "</tr>"
            $("table").append(dataToInsert);
             $("#no").val("");
            $("#name").val("");
            $("#subject").val("");
            $("#score").val("");
        }
    });
    $(document).on("click", ".delete", function () {
        let conf = confirm("삭제하시겠습니까?")
        if (conf === true) {
            $(this).remove();
        }
    });
</script>
</html>
