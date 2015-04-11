<%--
  Created by IntelliJ IDEA.
  User: sergei
  Date: 10.03.2015
  Time: 21:46
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Сообщения</title>
</head>
<h1>Посты</h1>
<br>
<style>

    html, body { margin: 0; padding: 0; }
    div { margin: 5px; text-align: center; }
    #box { position: absolute; width: 200px; }
    #left { position: absolute; }
    #right { position: relative; float: right; }

</style>
<body>

Данные из  requesta
<div id='box'>
<div id='left'>
    <table border=1>
<c:forEach var="user" items="${requestScope.user}" >
    <tr><td>${user.name}</td></tr>
</c:forEach>
    </table>
    </div>
<c:forEach var="posts" items="${requestScope.post}">
<div id='right'>
    <table border=1>
    <tr> <td>${posts.text}</td>
   <td> ${posts.date}</td>
   </tr>
</c:forEach>
</table>
    </div>
    </div>
<c:if test="${sessionScope.flag == true}">
    <form action="tst" method="post" accept-charset="utf-8">
        <div align="bottom">
            <p><b>Написать на форум:</b></p>

            <p><label>
                <textarea name="post"  rows="20" cols="100"></textarea>
            </label></p>
            <p><input type="submit"><input type="reset" value="Очистить"></p>
        </div>
    </form>
</c:if>
</body>
</html>
