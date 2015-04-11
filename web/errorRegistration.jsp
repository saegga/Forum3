<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sergei
  Date: 16.03.2015
  Time: 1:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:url var="url" value="/register.jsp"/>
<html>
<head>
    <title>Ошибка регистрации</title>
</head>
<body>
<div align="center">
 Во время регистрации произошла ошибка пользователь с таким именем уже существует <br>
 <a href="${url}" >Назад</a>
  </div>
</body>
</html>
