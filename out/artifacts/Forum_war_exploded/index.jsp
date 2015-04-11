<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<%--
  Created by IntelliJ IDEA.
  User: sergei
  Date: 10.03.2015
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Форумы</title>
</head>
<body>
<h1 align="center">Список форумов</h1>

<div align="right">
    <c:if test="${sessionScope.flag == true}">
        ${sessionScope.email}
    </c:if>
</div>
<div align="right">
    <a href="login.jsp">Регитсрация,авторизация</a>
</div>
<table border="1" align="center">
    <c:forEach var="forum" items="${requestScope.forums}">
        <tr>
            <td>
                    ${forum.id}
            </td>
            <td>
                <a href="subjects?id=${forum.id}">${forum.name}</a>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="test.jsp">Ссылка на тест</a>
</body>
</html>
