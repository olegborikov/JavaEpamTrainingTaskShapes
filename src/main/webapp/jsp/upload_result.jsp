<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Upload result</title>
</head>
<body>
${uploadResult}
<hr/>
<form action="/quadrangle/files" method="post">
    <input type="hidden" name="commandName" value="existing_files_display_command">
    <input type="submit" value="show quadrangles"/>
</form>
</body>
</html>
