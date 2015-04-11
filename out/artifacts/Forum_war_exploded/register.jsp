
<%--
  Created by IntelliJ IDEA.
  User: sergei
  Date: 14.03.2015
  Time: 0:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <title>Регистрация</title>
</head>
<body>
<h2 align = "center">Регистрация</h2>
<form action="reg" method="post">
<table align="center">
  <tr>
    <td>Имя</td>
    <td>
      <input type="text" name="log" >
    </td>
  </tr>
  <tr>
    <td>Эл.почта</td>
    <td>
      <input type="email" name="mail">
    </td>
  </tr>
  <tr>
    <td>Пароль</td>
    <td>
      <input type="password" name="pasw" >
    </td>
    </tr>
  <tr>
    <td>
      <input type="submit" value="Зарегистрироваться">
    </td>
  </tr>
</table>
  </form>
</body>
</html>
