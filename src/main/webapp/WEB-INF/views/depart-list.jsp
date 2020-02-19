<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 2/2/2020
  Time: 12:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:url value="/save-pageDepart" var="urlSave" />
<c:url value="/update-pageDepart/" var="urlUpdate" />
<c:url value="/removeDepart/" var="urlDelete" />

    <a href="${urlSave}">Add Depart</a>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
        </tr>
    <c:if test="${not empty depart}">
        <c:forEach var="derpart" items="${depart}">
            <tr>
                <td>${derpart.id}</td>
                <td>${derpart.name}</td>
                <td> <a href="${urlUpdate}/${derpart.id}">Update</a></td>
                <td> <a href="${urlDelete}/${derpart.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </c:if>
    </table>
    <hr>
</body>
</html>
