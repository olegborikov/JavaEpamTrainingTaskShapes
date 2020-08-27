<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>File choose</title>
    <link rel="stylesheet" type="text/css" href="css\bootstrap.min.css">
    <script type="text/javascript" src="js\bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <hr/>
    <form action="quadrangle" method="post">
        <input type="hidden" name="commandName" value="quadrangle_display_command">
        <p><select size="4" name="fileName">
            <option disabled>Choose file</option>
            <c:forEach var="f" items="${existingFiles}">
                <option>${f}</option>
            </c:forEach>
        </select></p>
        <input type="submit" value="Choose">
    </form>
    <hr/>
    <button onclick="history.back()">Previous Page</button>
    <hr/>
</div>
</body>
</html>
