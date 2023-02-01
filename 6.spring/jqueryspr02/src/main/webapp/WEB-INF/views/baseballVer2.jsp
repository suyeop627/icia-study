`
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<script src="https://code.jquery.com/jquery-3.6.1.min.js"
        integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ="
        crossorigin="anonymous"></script>
<html>
<head>
  <title>baseball version2</title>
  <style>
      * {
          margin: 0;
          padding: 0;

          text-align: center;
      }

      #count {
          font-size: 70px;
      }

      body {
          background-color: black;
      }

      button {
          color: white;
          font-size: 40px;
          width: 150px;
          height: 50px;
          border-radius: 10px;

          border: 2px solid;
          box-shadow:0 0 5px rgb(255, 255, 255),
          0 0 10px rgb(100, 255, 100),
          0 0 20px rgb(100, 255, 100),
          0 0 30px rgb(100, 255, 100);
          background-color: #ffffff00;
          text-shadow: 0 0 5px rgb(255, 255, 255),
          0 0 10px rgb(100, 255, 100),
          0 0 20px rgb(100, 255, 100);
          0 0 70px rgb(100, 255, 100);
      }

      #count {
          color: white;
          background-color: #ffffff00;
          text-shadow: 0 0 5px rgb(255, 255, 100),
          0 0 10px rgb(255, 255, 100),
          0 0 20px rgb(255, 255, 100);
          0 0 70px rgb(255, 255, 100);
      }


  </style>
</head>

<body>
<div id=btns>
  <button id="strike">Strike</button>
  <button id="ball">Ball</button>
  <button id="restart" style="display:none">Restart</button>
</div>
<br>
<div id=count>
  B : <b id="b">0</b><br>
  S : <b id="s">0</b><br>
  O : <b id="o">0</b><br>
</div>
</body>

<script>
    let ba = 0, st = 0, ou = 0;

    $("#strike").click(() => {
        st++;
        $("#s").html(st);
        if (st >= 3) {
            alert("스트라이크 아웃!!");
            ou++;
            $("#o").html(ou);
            init();
        }
        if (ou >= 3) {
            alert("3 아웃 게임 오버!");
            $("#restart").show();
            $("#strike").attr("disabled", true);
            $("#ball").attr("disabled", true);
        }
    })

    $("#ball").click(() => {
        ba++;
        $("#b").html(ba);
        if (ba >= 4) {
            alert("4볼!!");
            init();
        }
    })

    $("#restart").click(() => {
        ou = 0;
        $("#o").html(ou);
        init();
        $("#restart").hide();
        $("#strike").attr("disabled", false);
        $("#ball").attr("disabled", false);
    })

    function init() {
        st = 0;
        ba = 0;
        $("#s").html(st);
        $("#b").html(ba);
    }
</script>
</html>
`