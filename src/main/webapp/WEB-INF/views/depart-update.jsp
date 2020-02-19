<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 2/7/2020
  Time: 9:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="<c:url value="/list-depart"/>" >List Customer</a><br />

<h1>Add new Customer:</h1>
<c:url value="/updateDepart" var="saveDepart"/>
<form:form action="${saveDepart}" method="get"
           modelAttribute="depart">
    Name: <form:input path="id" /> <br/> <br/>
    Address: <form:input path="name" /> <br/> <br/>
    <button type="submit">Submit</button>
</form:form>
</body>
</html>
