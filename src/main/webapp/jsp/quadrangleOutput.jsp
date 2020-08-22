<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.borikov.task1.entity.Quadrangle" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Quadrangle Output</title>
</head>
<body>
<table border="1">
    <thead>
    <tr>
        <th>№</th>
        <th>Id</th>
        <th>Point 1</th>
        <th>Point 2</th>
        <th>Point 3</th>
        <th>Point 4</th>
    </tr>
    </thead>
    <tbody>
    <c:set var="i" value="1"/>
    <c:forEach var="q" items="${quadrangles}">
        <tr>
            <td>${i}</td>
            <td>${q.quadrangleId}</td>
            <td>(${q.point1.x},${q.point1.y})</td>
            <td>(${q.point2.x},${q.point2.y})</td>
            <td>(${q.point3.x},${q.point3.y})</td>
            <td>(${q.point4.x},${q.point4.y})</td>
        </tr>
        <c:set var="i" value="${i+1}"/>
    </c:forEach>
    </tbody>
</table>
</body>
</html>

