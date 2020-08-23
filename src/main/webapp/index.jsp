<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Quadrangle menu</title>
</head>
<body>
<hr/>
Uploads
<form action="upload" enctype="multipart/form-data" method="post">
    Upload File: <INPUT type="file" name="content" height="130">
    <INPUT type="submit" value="Upload File">
</form>

<form action="controller" method="get">
    <input type="hidden" name="commandType" value="quadrangle_display_command">
    <input type="submit" value="show all quadrangles"/>
</form>
</body>
</html>
