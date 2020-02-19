<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 2/2/2020
  Time: 12:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table border="1">
        <tr>
            <td>Nhân viên</td>
            <td>Loại</td>
            <td>Lý do</td>
            <td>Ngày ghi nhận</td>
        </tr>

    <c:if test="${not empty record}" >
        <c:forEach var="record" items="${record}">
            <tr>
                <td>${record.staffsEntity.name}</td>
                <c:if test="${record.type==1}">
                    <td>Thành tích</td>
                </c:if>
                <c:if test="${record.type==0}">
                <td>Kỷ luật</td>
                </c:if>
                <td>${record.reason}</td>
                <td>${record.date}</td>
            </tr>
        </c:forEach>
    </c:if>
    </table>
</body>
</html>
