<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Quadrangle menu</title>
</head>
<body>
<hr/>
Uploads
<form action="/upload" enctype="multipart/form-data" method="post">
    Upload File: <INPUT type="file" name="content" height="130">
    <INPUT type="submit" value="Upload File">
</form>
<hr/>
<form action="/quadrangle/files" method="post">
    <input type="hidden" name="commandName" value="existing_files_display_command">
    <input type="submit" value="show quadrangles"/>
</form>
<hr/>
</body>
