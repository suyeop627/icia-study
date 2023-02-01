<%--
  Created by IntelliJ IDEA.
  User: window
  Date: 2022-10-28
  Time: 오전 9:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>학점 등록</title>
  <style>
      table {
          width: 100%;
      }

      table, th, td {
          border: 1px solid;
          border-collapse: collapse;
      }

      th, td {
          padding: 10px 20px;
      }
  </style>
  <script src="js/jquery-3.6.1.min.js">
  </script>
  <script>
      $(function () {
          $("button").click(() => {
/*
              let num = $("#i1").val();
              let name = $("#i2").val();
              let cls = $("#i3").val();
              let score = $("#i4").val();
              let grade = $("#i5").val();
              let tagStr = "<tr>" +
                  "<td>" + num + "</td>" +
                  "<td>" + name + "</td>" +
                  "<td>" + cls + "</td>" +
                  "<td>" + score + "</td>" +
                  "<td>" + grade + "</td>" +
                  "<tr>";
*/
              let inputs = $("input");  //input태그 5개가 배열로 들어온다.

              let tagStr = "<tr>";

              //입력 개수에 맞게 반복처리.
              for(let i=0 ; i<inputs.length;i++){
                  tagStr += "<td>" + $(inputs[i]).val() + "</td>";
              }
              tagStr +="</tr>";

              $("table").append(tagStr);
          })
      })
  </script>
</head>
<body>
<table>
  <thead>학점등록</thead>
  <tr>
    <th>학번</th>
    <th>이름</th>
    <th>과목</th>
    <th>점수</th>
    <th>학점</th>
  </tr>
</table>
<br>
<fieldset>
  <legend>점수입력</legend>
  학번 : <input id="i1" type="text"><br>
  이름 : <input id="i2" type="text"><br>
  과목 : <input id="i3" type="text"><br>
  점수 : <input id="i4" type="text"><br>
  학점 : <input id="i5" type="text"><br>
  <button>입력</button>
</fieldset>
</body>
</html>
