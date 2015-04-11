<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sergei
  Date: 21.03.2015
  Time: 0:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js">
</script>
<html>
<head>
    <title></title>
  <script type="text/javascript">
    function runajax(){
      var inp0 = $("#inp0").val();
      $.ajax({
        type:"post",
        data: "keys=" + inp0,
        url:"mypackage.PostServlet",
        dataType:"text",
        success:function(data){
          var temp = data.content + " " + data.keys;
          $("#p1").text(temp);
        }

      })
    }

    $(document).ready(function(){
      $("#btn0").click(runajax());
    });

  </script>
</head>

<body>

<form action="posting" method="post" accept-charset="utf-8">
  <div align="bottom">
    <p><b>Написать на форум:</b></p>

    <p><label>
      <textarea name="post" id="inp0" rows="20" cols="100"></textarea>
    </label></p>

    <p><input type="button" value="Отправить"  id="btn0"><input type="reset" value="Очистить"></p>
  </div>
  Результат обработки запроса:
  <p id="p1"></p>
</form>
</body>
</html>
