<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>File choose</title>
</head>
<body>
<form action="controller" method="post">
    <input type="hidden" name="commandType" value="quadrangle_display_command">
    <p><select size="4" name="fileName">
        <option disabled>Choose file</option>
        <c:forEach var="f" items="${existingFiles}">
            <option>${f}</option>
        </c:forEach>
    </select></p>
    <p><input type="submit" value="Choose"></p>
</form>
</form>
</body>
</html>
