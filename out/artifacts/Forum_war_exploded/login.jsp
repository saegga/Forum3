<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%--
  Created by IntelliJ IDEA.
  User: sergei
  Date: 14.03.2015
  Time: 0:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Авторизация</title>
</head>
<body>

<form action="login" method="POST" accept-charset="utf-8">
    <h2 align="center">Авторизация</h2>
    <table align="center">
        <tr>
            <td><p><strong>Введите Имя: </strong></td>
            <td><input type="text" name="name" size="25"></td>
        </tr>

            <tr>
                <td>
        <strong>Введите пароль: </strong></td>
        <td><input type="password" size="25" name="password"></td>
        </tr>
            <tr>
                <td><input type="submit" value="Submit" name="s"></td>
                <td><input type="reset" value="Reset"></td>
            </tr>
    </table>
</form>
<div align="center">
<a href="register.jsp" >Регистрация</a>
    </div>


</body>
</html>
