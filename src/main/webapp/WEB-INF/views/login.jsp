<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 2/2/2020
  Time: 11:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html5>
<head>
    <title>Title</title>
</head>
<style>
    .error{
        color: red;
    }
</style>
<body>
    <a href="?language=en">English</a>|
    <a href="?language=vi_VN">Viet Nam</a>|
    <h2>hello :  <spring:message code="hello" text="default text" /></h2>

    Current Locale : ${pageContext.response.locale}
    <c:url value="/trangchu" var="loginUser"/>
    <h1>${Field}</h1><br>

    <form:form action="${loginUser}" method="post" modelAttribute="user">
        Username : <input type="text" name="username" value=""><form:errors path="username" cssClass="error"/><br><br>
        Password : <input type="text" name="password" value=""><form:errors path="password" cssClass="error"/><br><br>
        <input type="submit" value="Login">
    </form:form>
</body>
</html5>
































