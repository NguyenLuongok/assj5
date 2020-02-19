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
<c:url value="/save-pageStaff" var="urlSave" />
<c:url value="/update-pageStaff/" var="urlUpdate" />
<c:url value="/searchStaff" var="searchStaff"/>


    <h1>Staff List</h1>
    <a href="${urlSave}">Add Depart</a>
    <br><br/>
    <form action="${searchStaff}" method="get">
        <input type="text" name="nameStaff" value=""/>
        <input type="submit" value="Search"/>
    </form>
    <br><br/>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Gender</th>
                <th>Birthday</th>
                <th>Photo</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Salary</th>
                <th>Notes</th>
                <th>DepartID</th>
                <th>Update</th>
                <th>Delete</th>
            </tr>
            <c:if test="${not empty staff}">
                <c:forEach  var="staff" items="${staff}">
                    <tr>
                        <td>${staff.id}</td>
                        <td>${staff.name}</td>
                        <td>${staff.gender}</td>
                        <td>${staff.birthday}</td>
                        <td><img width="100px" height="100px" src="/resources/logos/${staff.photo}" alt=""></td>
                        <td>${staff.email}</td>
                        <td>${staff.phone}</td>
                        <td>${staff.salary}</td>
                        <td>${staff.notes}</td>
                        <td>${staff.departld}</td>
                        <td> <a href="${urlUpdate}/${staff.id}">Update</a></td>
                        <td>
                            <a href="/removeStaff/${staff.id}/${staff.photo}/">Delete</a>
                    </tr>
                </c:forEach>
            </c:if>
        </table>
</body>
</html>
