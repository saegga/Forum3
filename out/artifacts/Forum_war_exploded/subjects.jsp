<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sergei
  Date: 09.03.2015
  Time: 22:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<h1 align="center">Список Тем</h1>
<table align="center" border="1">
<c:forEach var="sub" items="${requestScope.subj}">
    <tr>
        <td>
                    ${sub.id}
                <a href="posts?id=${sub.id}">${sub.name}</a>
        </td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
