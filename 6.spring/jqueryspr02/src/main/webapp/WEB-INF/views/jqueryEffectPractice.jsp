<%--
  Created by IntelliJ IDEA.
  User: window
  Date: 2022-10-26
  Time: 오전 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <script src="https://code.jquery.com/jquery-3.6.1.min.js"
          integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ="
          crossorigin="anonymous"></script>
  <title>Title</title>
  <style>

      * {
          margin: 0;
          padding: 0;
          text-align: center;
      }

      li {
          list-style: none;
          display: none;


      }

      #main {
          margin: 0 auto;
          text-align: center;
      }

      #main > ul {
          background-color: burlywood;
      }

      #main > li > ul > li {
          background-color: bisque;
      }
      div{
          width : 500px;
          height : 500px;
      }
  </style>
  <script>
      $(function () {
          $("#main").click(function () {
              $("#main>li").slideDown("slow");
          });

          $("#sub1").click(function () {
              $("#sub1>li").slideToggle("slow");
          });
          $("#sub2").click(function () {
              $("#sub2>li").slideToggle("slow");
          });
          $("#sub3").click(function () {
              $("#sub3>li").slideToggle("slow");
          });


          $("#close").click(function () {
              $("#main>li").slideUp("slow");
          });
      })
  </script>
</head>
<body>
<div>
  <ul id="main">menu
    <li>
      <ul id="sub1">submenu1
        <li>list1</li>
        <li>list2</li>
        <li>list3</li>
      </ul>
    </li>
    <li>
      <ul id="sub2">submenu2
        <li>list1</li>
        <li>list2</li>
        <li>list3</li>
      </ul>
    </li>
    <li>
      <ul id="sub3">submenu3
        <li>list1</li>
        <li>list2</li>
        <li>list3</li>
      </ul>
    </li>
    <li id="close">close menu
    </li>
  </ul>
</div>

</body>
</html>
