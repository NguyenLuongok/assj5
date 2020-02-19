<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 2/7/2020
  Time: 10:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="<c:url value="/list-staff"/>" >List Staff</a><br />

<h1>Update Staff</h1>
<c:url value="/updateStaff" var="updateStaff"/>

    <form:form action="${updateStaff}" method="post" enctype="multipart/form-data" modelAttribute="staff">
        ID :<form:input path="id"/><br><br/>
        Name :<form:input path="name"/><br><br/>
        Gender:<form:select path="gender"><br><br/>
        <form:option value="Nam">Nam</form:option>
        <form:option value="Nu">Nữ</form:option>
    </form:select><br><br/>
        Ngày sinh :<form:input path="birthday" value="${staff.birthday}" type="date"/><br><br/>
        Ảnh :<input type="file" name="file"/><br><br/>
        Email:<form:input path="email" type="email"/><br><br/>
        Số điện thoại:<form:input path="phone"/><br><br/>
        Lương: <form:input path="salary"/><br><br/>
        Ghi chú :<form:input path="notes"/><br><br/>
        Mã phòng ban :<form:input path="departld"/><br><br/>
        <button type="submit">Update</button>
    </form:form>
</body>
</html>
